package javaPrograms;

import java.util.*;

public class CollectionsStandardDemo {

    public static void main(String[] args) {
        System.out.println("========== 1. LIST vs SET vs QUEUE BEHAVIOR ==========\n");
        runCollectionBasicsDemo();

        System.out.println("\n========== 2. CORE MAP OPERATIONS ==========\n");
        runMapMechanicsDemo();
    }

    /**
     * Demonstrates ordering, duplicate handling, and processing sequences
     */
    private static void runCollectionBasicsDemo() {
        // 1. LIST: Preserves insertion order, allows duplicates, fast indexing
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("Java"); // Duplicate entry
        System.out.println("ArrayList (Ordered, Duplicates allowed): " + arrayList);

        // 2. SET: Unique elements only, HashSet does NOT preserve order
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Banana"); // Ignored automatically
        System.out.println("HashSet (Unique, Unordered): " + hashSet);

        // 3. SORTED SET: TreeSet automatically sorts elements alphabetically/naturally
        Set<String> treeSet = new TreeSet<>(hashSet);
        treeSet.add("Cherry");
        System.out.println("TreeSet (Unique, Sorted alphabetically): " + treeSet);

        // 4. QUEUE: PriorityQueue orders items by priority (Lowest value first by default)
        Queue<Integer> pQueue = new PriorityQueue<>();
        pQueue.add(40);
        pQueue.add(10);
        pQueue.add(30);
        
        System.out.print("PriorityQueue Poll sequence (Lowest out first): ");
        while (!pQueue.isEmpty()) {
            System.out.print(pQueue.poll() + " "); // Removes and returns head element
        }
        System.out.println();
    }

    /**
     * Demonstrates safe population, retrieval, and iteration of Key-Value pairs
     */
    private static void runMapMechanicsDemo() {
        Map<String, Double> stockPrices = new HashMap<>();

        // Adding values
        stockPrices.put("AAPL", 175.50);
        stockPrices.put("GOOGL", 140.25);
        stockPrices.put("MSFT", 420.00);

        // Updating / Overwriting an existing value
        stockPrices.put("AAPL", 180.00); 

        // Safe retrieval using getOrDefault (prevents NullPointerException)
        Double metaPrice = stockPrices.getOrDefault("META", 0.0);
        System.out.println("META Price (Not found fallback): $" + metaPrice);

        // Checking existence of a specific key
        if (stockPrices.containsKey("MSFT")) {
            System.out.println("MSFT ticker is successfully tracked.");
        }

        // Iterating efficiently using entrySet
        System.out.println("\n--- Current Stock Portfolio ---");
        for (Map.Entry<String, Double> entry : stockPrices.entrySet()) {
            System.out.println("Ticker: " + entry.getKey() + " | Price: $" + entry.getValue());
        }
    }
}
