package main.java.com.geode.demo.csv;

public class GeodeConnectionManager implements AutoCloseable {

    private final ClientCache cache;
    private final Region<String, Map<String, String>> region;

    public GeodeConnectionManager(GeodeConfig config) {
        this.cache = new ClientCacheFactory()
                .addPoolLocator(config.getLocatorHost(), config.getLocatorPort())
                .create();

        this.region = cache.<String, Map<String, String>>createClientRegionFactory(
                ClientRegionShortcut.PROXY)
                .create(config.getRegionName());
    }

    public Region<String, Map<String, String>> getRegion() {
        return region;
    }

    @Override
    public void close() {
        if (cache != null) {
            cache.close();
        }
    }
}