package javaPrograms;

import java.util.*;

// ============================================================================
// DOMAIN MODEL CLASS
// ============================================================================
class Product {
    private String name;
    private String category;
    private double price;
    private double rating;

    public Product(String name, String category, double price, double rating) {
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
public class CollectionsComparableAndComparatorDemo {

    public static void main(String[] args) {
        // Sample Data Source
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.00, 4.7),
            new Product("Smartphone", "Electronics", 800.00, 4.5),
            new Product("Coffee Maker", "Appliances", 150.00, 4.2),
            new Product("Blender", "Appliances", 80.00, 4.5),
            new Product("Headphones", "Electronics", 150.00, 4.8)
        );

        System.out.println("==================================================");
        System.out.println("MASTERING COMPARATORS (ORDERING LOGIC)");
        System.out.println("==================================================");

        // 1. Modern Lambda Comparator (Sorting by Price Ascending)
        System.out.println("\n1. Sorted by Price (Low to High):");
        products.sort(Comparator.comparingDouble(Product::getPrice));
        products.forEach(product -> System.out.println(product));

        // 2. Reversing a Comparator (Sorting by Price Descending)
        System.out.println("\n2. Sorted by Price (High to Low):");
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        products.forEach(product -> System.out.println(product));

        // 3. Multi-Level Chaining (Sort by Price, then break ties by Rating Descending)
        System.out.println("\n3. Chained Sort (By Price Descending, then Rating Descending for ties):");
        // Headphones and Coffee Maker are both $150.00. Headphones (4.8) will jump ahead of Coffee Maker (4.2).
        products.sort(
            Comparator.comparingDouble(Product::getPrice).reversed()
                      .thenComparing(Comparator.comparingDouble(Product::getRating).reversed())
        );
        products.forEach(product -> System.out.println(product));

     }
}
