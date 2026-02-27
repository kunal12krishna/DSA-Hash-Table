package P9_TwoSumVariants;

import java.util.*;

public class TransactionAnalyzer {

    // Classic Two-Sum
    public void findTwoSum(List<Transaction> transactions, int target) {

        HashMap<Integer, Transaction> map = new HashMap<>();

        for (Transaction t : transactions) {

            int complement = target - t.amount;

            if (map.containsKey(complement)) {
                System.out.println("Fraud Pair Found:");
                System.out.println(map.get(complement));
                System.out.println(t);
                return;
            }

            map.put(t.amount, t);
        }

        System.out.println("No suspicious pair found.");
    }

    // Duplicate detection (same amount + merchant)
    public void detectDuplicates(List<Transaction> transactions) {

        HashMap<String, List<Transaction>> duplicateMap = new HashMap<>();

        for (Transaction t : transactions) {

            String key = t.amount + "_" + t.merchant;

            duplicateMap
                    .computeIfAbsent(key, k -> new ArrayList<>())
                    .add(t);
        }

        System.out.println("\nDuplicate Transactions:");

        for (Map.Entry<String, List<Transaction>> entry : duplicateMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                for (Transaction t : entry.getValue()) {
                    System.out.println(t);
                }
                System.out.println("----");
            }
        }
    }
}