package main.java.com.geode.demo.mono;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GeodeCSVLoader {
    private final ClientCache cache;
    private final Region<String, Map<String, String>> region;
    
    public GeodeCSVLoader(String locatorHost, int locatorPort, String regionName) {
        // Initialize Geode client cache
        this.cache = new ClientCacheFactory()
            .addPoolLocator(locatorHost, locatorPort)
            .create();
            
        // Get or create the region
        this.region = cache.<String, Map<String, String>>createClientRegionFactory(
            ClientRegionShortcut.PROXY)
            .create(regionName);
    }
    
    public void loadCSV(String csvFilePath, String keyColumn) throws IOException {
        AtomicInteger batchSize = new AtomicInteger(0);
        final int BATCH_LIMIT = 1000; // Adjust as needed
        Map<String, Map<String, String>> batch = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            String[] headers = br.readLine().split(","); // Read headers
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> record = new HashMap<>();
                
                // Create record from headers and values
                for (int i = 0; i < headers.length; i++) {
                    if (i < values.length) {
                        record.put(headers[i].trim(), values[i].trim());
                    }
                }
                
                // Use specified column as key
                String key = record.get(keyColumn);
                if (key != null) {
                    batch.put(key, record);
                    batchSize.incrementAndGet();
                    
                    // Process batch if limit reached
                    if (batchSize.get() >= BATCH_LIMIT) {
                        processBatch(batch);
                        batch.clear();
                        batchSize.set(0);
                    }
                }
            }
            
            // Process remaining records
            if (!batch.isEmpty()) {
                processBatch(batch);
            }
        }
    }
    
    private void processBatch(Map<String, Map<String, String>> batch) {
        try {
            region.putAll(batch);
            System.out.println("Processed batch of " + batch.size() + " records");
        } catch (Exception e) {
            System.err.println("Error processing batch: " + e.getMessage());
            // Implement retry logic here
        }
    }
    
    public void close() {
        if (cache != null) {
            cache.close();
        }
    }
    
    public static void main(String[] args) {
        String locatorHost = "localhost";
        int locatorPort = 10334;
        String regionName = "myRegion";
        String csvFile = "data.csv";
        String keyColumn = "id"; // Specify which column to use as key
        
        GeodeCSVLoader loader = new GeodeCSVLoader(locatorHost, locatorPort, regionName);
        
        try {
            loader.loadCSV(csvFile, keyColumn);
        } catch (IOException e) {
            System.err.println("Error loading CSV: " + e.getMessage());
        } finally {
            loader.close();
        }
    }
}