package main.java.com.geode.demo.csv;

public class BatchProcessor {
    private final int batchSize;
    private final Map<String, Map<String, String>> batch;
    private int currentSize;
    
    public BatchProcessor(int batchSize) {
        this.batchSize = batchSize;
        this.batch = new HashMap<>();
        this.currentSize = 0;
    }
    
    public void add(String key, Map<String, String> record) {
        batch.put(key, record);
        currentSize++;
    }
    
    public boolean isReadyToProcess() {
        return currentSize >= batchSize;
    }
    
    public Map<String, Map<String, String>> getBatch() {
        return new HashMap<>(batch);
    }
    
    public void clear() {
        batch.clear();
        currentSize = 0;
    }
    
    public boolean isEmpty() {
        return batch.isEmpty();
    }

}