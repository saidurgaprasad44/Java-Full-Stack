package javaPrograms;

import java.util.*;

//============================================================================
//HELPER DOMAIN MODEL CLASSES
//============================================================================

class CartItem {
 private String name;
 private double price;
 private int quantity;

 public CartItem(String id, String name, double price, int quantity) {
     this.name = name;
     this.price = price;
     this.quantity = quantity;
 }

 public String getName() { return name; }
 public double getPrice() { return price; }
 public int getQuantity() { return quantity; }
}

enum Tier { STANDARD, GOLD, PLATINUM }

class SupportTicket implements Comparable<SupportTicket> {
 private String description;
 private Tier customerTier;

 public SupportTicket(String description, Tier customerTier) {
     this.description = description;
     this.customerTier = customerTier;
 }

 // High tier items priority sort. We override compareTo to implement this logic.
 @Override
 public int compareTo(SupportTicket other) {
     return Integer.compare(other.customerTier.ordinal(), this.customerTier.ordinal());
 }

 @Override
 public String toString() {
     return "[" + customerTier + "] " + description;
 }
}

//============================================================================
//MAIN APPLICATION FILE
//============================================================================

public class CollectionsUseCasesDemo {

 public static void main(String[] args) {
     System.out.println("========== USE CASE 1: E-COMMERCE SHOPPING CART (LIST & ITERATOR) ==========\n");
     runShoppingCartUseCase();

     System.out.println("\n========== USE CASE 2: FRAUD DETECTION LOG FILTER (HASHSET) ==========\n");
     runFraudLogUseCase();

     System.out.println("\n========== USE CASE 3: CUSTOMER SERVICE SLA SYSTEM (PRIORITYQUEUE) ==========\n");
     runCustomerSupportUseCase();

     System.out.println("\n========== USE CASE 4: ENTERPRISE INVENTORY AGGREGATOR (HASHMAP) ==========\n");
     runInventoryUseCase();
 }

 private static void runShoppingCartUseCase() {
     List<CartItem> cart = new ArrayList<>();

     cart.add(new CartItem("P101", "Laptop Wireless Mouse", 25.00, 1));
     cart.add(new CartItem("P205", "Mechanical Keyboard", 85.50, 1));
     cart.add(new CartItem("P309", "USB-C Hub (Out of Stock)", 40.00, 2));

     // CRITICAL MECHANISM: Using an Iterator to safely remove items while looping
     // Standard for-each loops will throw a ConcurrentModificationException here!
     Iterator<CartItem> iterator = cart.iterator();
     while (iterator.hasNext()) {
         CartItem item = iterator.next();
         if (item.getName().contains("Out of Stock")) {
             System.out.println("Removing unavailable item: " + item.getName());
             iterator.remove(); 
         }
     }

     // Calculating Total Cost
     double total = 0;
     for (CartItem item : cart) {
         total += item.getPrice() * item.getQuantity();
     }
     System.out.println("Total checkout price: $" + total);
 }

 private static void runFraudLogUseCase() {
     List<String> rawServerLogs = Arrays.asList(
         "192.168.1.50", "10.0.0.1", "192.168.1.50", 
         "172.16.0.5", "10.0.0.1", "192.168.1.50"
     );

     // Deduplicate instantly by passing the collection into a Set constructor
     Set<String> uniqueFlaggedIPs = new HashSet<>(rawServerLogs);

     System.out.println("Total raw hits logged: " + rawServerLogs.size());
     System.out.println("Unique malicious IPs isolated: " + uniqueFlaggedIPs.size());
     System.out.println("Blacklist to push to firewall: " + uniqueFlaggedIPs);
     
     // Fast instant lookup check O(1) performance
     String suspectIP = "10.0.0.1";
     if (uniqueFlaggedIPs.contains(suspectIP)) {
         System.out.println("Alert Verification: " + suspectIP + " is confirmed a bad actor.");
     }
 }

 private static void runCustomerSupportUseCase() {
     Queue<SupportTicket> ticketQueue = new PriorityQueue<>();

     // Tickets added in random structural order
     ticketQueue.add(new SupportTicket("Password Reset Request", Tier.STANDARD));
     ticketQueue.add(new SupportTicket("Database Server Crashed!", Tier.PLATINUM)); 
     ticketQueue.add(new SupportTicket("UI Font alignment issue", Tier.GOLD));

     System.out.println("--- Processing Tickets by SLA Priority ---");
     while (!ticketQueue.isEmpty()) {
         // The Platinum ticket will always be pulled out first regardless of order added
         System.out.println("Handling ticket: " + ticketQueue.poll());
     }
 }

 private static void runInventoryUseCase() {
     List<String> incomingScans = Arrays.asList(
         "iPhone15", "GalaxyS24", "iPhone15", 
         "MacBookPro", "iPhone15", "GalaxyS24"
     );

     Map<String, Integer> stockCountMap = new HashMap<>();

     for (String product : incomingScans) {
         // PRO-TIP MECHANISM: merge() computes value increments automatically
         // If key doesn't exist: initializes value to 1
         // If key exists: applies the rule (adds current count + 1)
         stockCountMap.merge(product, 1, Integer::sum);
     }

     System.out.println("--- Warehouse Stock Status ---");
     stockCountMap.forEach((product, count) -> 
         System.out.println("Product SKU: " + product + " | In-Stock: " + count)
     );
 }
}
