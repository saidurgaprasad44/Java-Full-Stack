package javaPrograms;

import java.util.*;
import java.util.stream.Collectors;

// ============================================================================
// DOMAIN MODEL CLASS
// ============================================================================
class Item {
    private String name;
    private String category;
    private double price;
    private double rating;

    public Item(String name, String category, double price, double rating) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return String.format("%s[%s, $%.2f, ⭐%.1f]", name, category, price, rating);
    }
}

// ============================================================================
// MAIN APPLICATION FILE
// ============================================================================
public class StreamAPICollectorsDemo {

    public static void main(String[] args) {
        // Sample Data Source
        List<Item> items = Arrays.asList(
            new Item("Laptop", "Electronics", 1200.00, 4.7),
            new Item("Smartphone", "Electronics", 800.00, 4.5),
            new Item("Coffee Maker", "Appliances", 150.00, 4.2),
            new Item("Blender", "Appliances", 80.00, 4.5),
            new Item("Headphones", "Electronics", 150.00, 4.8)
        );

        System.out.println("\n==================================================");
        System.out.println("MASTERING COLLECTORS (DATA AGGREGATION)");
        System.out.println("==================================================");
        // Note: We use simple streams here just to feed data into the collectors.

        // 1. Accumulating into specific collection structures
        System.out.println("\n1. Accumulating into a Set (Removes duplicate categories):");
        Set<String> uniqueCategories = items.stream()
            .map(Item::getCategory)
            .collect(Collectors.toSet()); // Bundles into a HashSet
        System.out.println("Categories found: " + uniqueCategories);

        // 2. Data Summarization (Math operations)
        System.out.println("\n2. Summary Statistics (Averaging & Summing):");
        double avgPrice = items.stream()
            .collect(Collectors.averagingDouble(Item::getPrice));
        System.out.println("Average Item Price: $" + avgPrice);

        // DoubleSummaryStatistics gives you count, sum, min, average, and max all at once!
        DoubleSummaryStatistics priceStats = items.stream()
            .collect(Collectors.summarizingDouble(Item::getPrice));
        System.out.println("Full Price Stats: " + priceStats);

        // 3. Transforming items during collection (mapping)
        System.out.println("\n3. Collecting and converting names into a single String:");
        String itemMarquee = items.stream()
            .map(Item::getName)
            .collect(Collectors.joining(" | ", "[Catalog: ", " ]"));
        System.out.println(itemMarquee);

        // 4. Finding Extreme Values (Max/Min via Collectors)
        System.out.println("\n4. Finding the highest-rated item using a Collector + Comparator:");
        // Collectors.maxBy requires a Comparator to know what "highest" means
        Optional<Item> topRatedItem = items.stream()
            .collect(Collectors.maxBy(Comparator.comparingDouble(Item::getRating)));
        
        topRatedItem.ifPresent(p -> System.out.println("Top Rated: " + p));
    }
}

