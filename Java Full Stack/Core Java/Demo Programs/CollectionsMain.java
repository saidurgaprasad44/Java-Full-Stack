package javaPrograms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

public class CollectionsMain {
    public static void main(String[] args) {
        
        // ---------------------------------------------------------
        // 1-3. LIST, SET, QUEUE (All extending Collection<E>)
        // ---------------------------------------------------------
        
        // Using a List to demonstrate most of the root methods
        Collection<String> fruits = new ArrayList<>();

        // 1. Adding Elements
        fruits.add("Apple");
        fruits.addAll(Arrays.asList("Banana", "Cherry", "Date"));

        // 2. Removing Elements
        fruits.remove("Date");
        Predicate<String> p=f -> f.startsWith("B");
        fruits.removeIf(p); // Lambda: removes "Banana"

        // 3. Checking State
        System.out.println("Size of collection: " + fruits.size());
        System.out.println("Contains 'Apple'? " + fruits.contains("Apple"));
        System.out.println("Is empty? " + fruits.isEmpty());

        // 4. Conversion & Bulk Operations
        Object[] fruitArray=fruits.toArray();
        
        // Iterator for manual looping and safe removal
        Iterator<String> it = fruits.iterator();
        while(it.hasNext()) {
            String f = it.next();
            if(f.equals("Cherry")) it.remove();
        }

        // Stream for modern operations
        fruits.add("Elderberry");
        fruits.stream()
              .filter(f -> f.length() > 5)
              .forEach(f -> System.out.println("Stream filtered fruit: " + f));

        // 5. Comparison
        int hash = fruits.hashCode();
        System.out.println("Collection HashCode: " + hash);


        // ---------------------------------------------------------
        // 4. MAP (Independent Interface)
        // ---------------------------------------------------------
        System.out.println("\n--- Map Operations ---");
        Map<Integer, String> langMap = new HashMap<>();

        // Map Specific Methods
        langMap.put(1, "Java");
        langMap.put(2, "Python");
        langMap.put(3, "JavaScript");

        System.out.println("Value for key 1: " + langMap.get(1));
        System.out.println("Contains key 2? " + langMap.containsKey(2));
        System.out.println("Contains value 'C++'? " + langMap.containsValue("C++"));

        langMap.remove(3); // Removes key 3
        System.out.println("Final Map Size: " + langMap.size());
    }
}