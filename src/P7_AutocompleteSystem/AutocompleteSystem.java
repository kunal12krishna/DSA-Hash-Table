package P7_AutocompleteSystem;

import java.util.*;

public class AutocompleteSystem {

    private HashMap<String, Integer> queryFrequency;

    public AutocompleteSystem() {
        queryFrequency = new HashMap<>();
    }

    // Add or update query
    public void addQuery(String query) {
        queryFrequency.put(query,
                queryFrequency.getOrDefault(query, 0) + 1);
    }

    // Search top 5 suggestions
    public List<String> search(String prefix) {

        PriorityQueue<Map.Entry<String, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : queryFrequency.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                maxHeap.add(entry);
            }
        }

        List<String> result = new ArrayList<>();
        int count = 0;

        while (!maxHeap.isEmpty() && count < 5) {
            result.add(maxHeap.poll().getKey());
            count++;
        }

        return result;
    }
}