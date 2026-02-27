package P10_MultiLevelCache;

public class Main {

    public static void main(String[] args) {

        MultiLevelCache cache = new MultiLevelCache(3);

        cache.put("video1", "Movie A");
        cache.put("video2", "Movie B");
        cache.put("video3", "Movie C");

        System.out.println(cache.get("video1")); // L3 → L2
        System.out.println(cache.get("video1")); // L2 → L1
        System.out.println(cache.get("video1")); // L1 hit

        System.out.println(cache.get("video2"));
        System.out.println(cache.get("video3"));

        cache.showStats();
    }
}