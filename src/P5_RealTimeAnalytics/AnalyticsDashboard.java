package P5_RealTimeAnalytics;

import java.util.*;

public class AnalyticsDashboard {

    private HashMap<String, Integer> pageViews;
    private HashMap<String, Set<String>> uniqueVisitors;
    private HashMap<String, Integer> trafficSources;

    public AnalyticsDashboard() {
        pageViews = new HashMap<>();
        uniqueVisitors = new HashMap<>();
        trafficSources = new HashMap<>();
    }

    // Process incoming page view
    public void processEvent(String url, String userId, String source) {

        // Increment page views
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        // Track unique visitors
        uniqueVisitors
                .computeIfAbsent(url, k -> new HashSet<>())
                .add(userId);

        // Track traffic source
        trafficSources.put(source,
                trafficSources.getOrDefault(source, 0) + 1);
    }

    // Display dashboard
    public void showDashboard() {

        System.out.println("===== TOP PAGES =====");

        pageViews.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(10)
                .forEach(entry -> {
                    String url = entry.getKey();
                    System.out.println(url +
                            " | Views: " + entry.getValue() +
                            " | Unique Visitors: " +
                            uniqueVisitors.get(url).size());
                });

        System.out.println("\n===== TRAFFIC SOURCES =====");
        trafficSources.forEach((source, count) ->
                System.out.println(source + ": " + count));
    }
}