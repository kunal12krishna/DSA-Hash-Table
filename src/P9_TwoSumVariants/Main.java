package P9_TwoSumVariants;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(1, 500, "StoreA"));
        transactions.add(new Transaction(2, 300, "StoreB"));
        transactions.add(new Transaction(3, 200, "StoreC"));
        transactions.add(new Transaction(4, 500, "StoreA"));

        TransactionAnalyzer analyzer = new TransactionAnalyzer();

        analyzer.findTwoSum(transactions, 500);
        analyzer.detectDuplicates(transactions);
    }
}