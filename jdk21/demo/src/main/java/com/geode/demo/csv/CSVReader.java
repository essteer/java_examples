package main.java.com.geode.demo.csv;

public class CSVReader {
    private final String[] headers;
    private final BufferedReader reader;
    
    public CSVReader(String csvFilePath) throws IOException {
        this.reader = new BufferedReader(new FileReader(csvFilePath));
        this.headers = reader.readLine().split(",");
    }
    
    public Map<String, String> readNext() throws IOException {
        String line = reader.readLine();
        if (line == null) return null;
        
        String[] values = line.split(",");
        Map<String, String> record = new HashMap<>();
        
        for (int i = 0; i < headers.length; i++) {
            if (i < values.length) {
                record.put(headers[i].trim(), values[i].trim());
            }
        }
        
        return record;
    }
    
    public void close() throws IOException {
        reader.close();
    }
}
