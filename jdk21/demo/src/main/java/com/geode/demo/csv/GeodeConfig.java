package main.java.com.geode.demo.csv;

public class GeodeConfig {

    private final String locatorHost;
    private final int locatorPort;
    private final String regionName;

    public GeodeConfig(String locatorHost, int locatorPort, String regionName) {
        this.locatorHost = locatorHost;
        this.locatorPort = locatorPort;
        this.regionName = regionName;
    }

    // Getters
    public String getLocatorHost() {
        return locatorHost;
    }

    public int getLocatorPort() {
        return locatorPort;
    }

    public String getRegionName() {
        return regionName;
    }
}