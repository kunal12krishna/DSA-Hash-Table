
        package P1_UsernameChecker;

import java.util.*;

public class UsernameService {

    private HashMap<String, Integer> usernameMap;
    private HashMap<String, Integer> attemptCount;

    public UsernameService() {
        usernameMap = new HashMap<>();
        attemptCount = new HashMap<>();
    }

    // Register new user
    public boolean registerUser(String username, int userId) {
        attemptCount.put(username, attemptCount.getOrDefault(username, 0) + 1);

        if (usernameMap.containsKey(username)) {
            return false;
        }

        usernameMap.put(username, userId);
        return true;
    }

    // Check availability
    public boolean checkAvailability(String username) {
        attemptCount.put(username, attemptCount.getOrDefault(username, 0) + 1);
        return !usernameMap.containsKey(username);
    }

    // Suggest alternatives
    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String suggestion = username + i;
            if (!usernameMap.containsKey(suggestion)) {
                suggestions.add(suggestion);
            }
        }

        String dotVersion = username.replace("_", ".");
        if (!usernameMap.containsKey(dotVersion)) {
            suggestions.add(dotVersion);
        }

        return suggestions;
    }

    // Get most attempted username
    public String getMostAttempted() {
        String mostAttempted = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : attemptCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostAttempted = entry.getKey();
            }
        }

        return mostAttempted + " (" + maxCount + " attempts)";
    }
}