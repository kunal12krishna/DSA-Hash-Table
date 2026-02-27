package P6_RateLimiter;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        RateLimiter limiter = new RateLimiter(3, 5000); // 3 requests per 5 seconds

        String client = "client123";

        for (int i = 1; i <= 5; i++) {
            System.out.println("Request " + i + ": " +
                    limiter.allowRequest(client));
        }

        System.out.println("Waiting for refill...");
        Thread.sleep(6000);

        System.out.println("After refill:");
        System.out.println("Request: " +
                limiter.allowRequest(client));
    }
}