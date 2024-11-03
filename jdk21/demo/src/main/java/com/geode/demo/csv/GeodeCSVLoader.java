package main.java.com.geode.demo.csv;

public class GeodeCSVLoader {
    private final GeodeConnectionManager connectionManager;
    private final BatchProcessor batchProcessor;
    private static final int DEFAULT_BATCH_SIZE = 1000;
    
    public GeodeCSVLoader(GeodeConfig config) {
        this.connectionManager = new GeodeConnectionManager(config);
        this.batchProcessor = new BatchProcessor(DEFAULT_BATCH_SIZE);
    }
    
    public void loadCSV(String csvFilePath, String keyColumn) throws IOException {
        try (CSVReader csvReader = new CSVReader(csvFilePath)) {
            Map<String, String> record;
            while ((record = csvReader.readNext()) != null) {
                String key = record.get(keyColumn);
                if (key != null) {
                    batchProcessor.add(key, record);
                    
                    if (batchProcessor.isReadyToProcess()) {
                        processBatch();
                    }
                }
            }
            
            // Process remaining records
            if (!batchProcessor.isEmpty()) {
                processBatch();
            }
        }
    }
    
    private void processBatch() {
        try {
            Region<String, Map<String, String>> region = connectionManager.getRegion();
            Map<String, Map<String, String>> batchToProcess = batchProcessor.getBatch();
            region.putAll(batchToProcess);
            System.out.println("Processed batch of " + batchToProcess.size() + " records");
        } catch (Exception e) {
            System.err.println("Error processing batch: " + e.getMessage());
        } finally {
            batchProcessor.clear();
        }
    }
    
    public void close() {
        connectionManager.close();
    }
    
    // Example usage
    public static void main(String[] args) {
        GeodeConfig config = new GeodeConfig("localhost", 10334, "myRegion");
        
        try (GeodeCSVLoader loader = new GeodeCSVLoader(config)) {
            loader.loadCSV("data.csv", "id");
        } catch (IOException e) {
            System.err.println("Error loading CSV: " + e.getMessage());
        }
    }
}