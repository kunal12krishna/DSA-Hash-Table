package P10_MultiLevelCache;

import java.util.*;

public class MultiLevelCache {

    private LinkedHashMap<String, String> L1;
    private HashMap<String, String> L2;
    private HashMap<String, String> L3;

    private int l1Hits = 0;
    private int l2Hits = 0;
    private int l3Hits = 0;

    public MultiLevelCache(int l1Capacity) {

        // L1 with LRU eviction
        L1 = new LinkedHashMap<>(l1Capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > l1Capacity;
            }
        };

        L2 = new HashMap<>();
        L3 = new HashMap<>();
    }

    // Add data to L3 (database)
    public void put(String key, String value) {
        L3.put(key, value);
    }

    // Retrieve data
    public String get(String key) {

        if (L1.containsKey(key)) {
            l1Hits++;
            return "L1 HIT → " + L1.get(key);
        }

        if (L2.containsKey(key)) {
            l2Hits++;
            String value = L2.get(key);
            L1.put(key, value); // Promote to L1
            return "L2 HIT → Promoted to L1";
        }

        if (L3.containsKey(key)) {
            l3Hits++;
            String value = L3.get(key);
            L2.put(key, value); // Add to L2
            return "L3 HIT → Added to L2";
        }

        return "MISS";
    }

    public void showStats() {

        int total = l1Hits + l2Hits + l3Hits;

        System.out.println("\n===== CACHE STATS =====");
        System.out.println("L1 Hits: " + l1Hits);
        System.out.println("L2 Hits: " + l2Hits);
        System.out.println("L3 Hits: " + l3Hits);

        if (total > 0) {
            System.out.println("Overall Hit Rate: " +
                    (total * 100.0 / total) + "%");
        }
    }
}