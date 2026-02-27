package P6_RateLimiter;

import java.util.HashMap;

public class RateLimiter {

    private static class TokenBucket {
        int tokens;
        long lastRefillTime;

        TokenBucket(int maxTokens) {
            this.tokens = maxTokens;
            this.lastRefillTime = System.currentTimeMillis();
        }
    }

    private HashMap<String, TokenBucket> clientBuckets;
    private final int MAX_TOKENS;
    private final long REFILL_INTERVAL; // in milliseconds

    public RateLimiter(int maxTokens, long refillIntervalMillis) {
        this.MAX_TOKENS = maxTokens;
        this.REFILL_INTERVAL = refillIntervalMillis;
        this.clientBuckets = new HashMap<>();
    }

    public synchronized boolean allowRequest(String clientId) {

        long now = System.currentTimeMillis();

        clientBuckets.putIfAbsent(clientId, new TokenBucket(MAX_TOKENS));
        TokenBucket bucket = clientBuckets.get(clientId);

        // Refill tokens if interval passed
        if (now - bucket.lastRefillTime >= REFILL_INTERVAL) {
            bucket.tokens = MAX_TOKENS;
            bucket.lastRefillTime = now;
        }

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }
}