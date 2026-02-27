

        package P2_FlashSaleInventory;

import java.util.*;

public class InventoryManager {

    private HashMap<String, Integer> stockMap;
    private HashMap<String, Queue<Integer>> waitingList;

    public InventoryManager() {
        stockMap = new HashMap<>();
        waitingList = new HashMap<>();
    }

    // Add product with stock
    public void addProduct(String productId, int stock) {
        stockMap.put(productId, stock);
        waitingList.put(productId, new LinkedList<>());
    }

    // Check stock
    public int checkStock(String productId) {
        return stockMap.getOrDefault(productId, 0);
    }

    // Thread-safe purchase
    public synchronized String purchaseItem(String productId, int userId) {

        int currentStock = stockMap.getOrDefault(productId, 0);

        if (currentStock > 0) {
            stockMap.put(productId, currentStock - 1);
            return "Purchase Success! Remaining stock: " + (currentStock - 1);
        } else {
            Queue<Integer> queue = waitingList.get(productId);
            queue.add(userId);
            return "Out of stock. Added to waiting list. Position: " + queue.size();
        }
    }

    // View waiting list size
    public int getWaitingListSize(String productId) {
        return waitingList.get(productId).size();
    }
}