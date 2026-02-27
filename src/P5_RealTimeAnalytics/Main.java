package P5_RealTimeAnalytics;

public class Main {

    public static void main(String[] args) {

        AnalyticsDashboard dashboard = new AnalyticsDashboard();

        dashboard.processEvent("/article/news", "user1", "Google");
        dashboard.processEvent("/article/news", "user2", "Facebook");
        dashboard.processEvent("/sports/match", "user3", "Google");
        dashboard.processEvent("/article/news", "user1", "Direct");

        dashboard.showDashboard();
    }
}