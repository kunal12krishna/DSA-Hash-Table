package P3_DNSCache;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        DNSCache cache = new DNSCache(3);

        System.out.println(cache.resolve("google.com"));
        System.out.println(cache.resolve("google.com"));

        Thread.sleep(6000); // Wait for TTL to expire

        System.out.println(cache.resolve("google.com"));

        System.out.println(cache.resolve("github.com"));
        System.out.println(cache.resolve("stackoverflow.com"));
        System.out.println(cache.resolve("openai.com")); // triggers LRU eviction

        cache.getCacheStats();
    }
}