package javaPrograms;

//import java.util.Arrays;

public class Enumeration {

	public static void main(String[] args) {
		
		OrderStatus[] orderStatuses = OrderStatus.values();
		OrderStatus status = OrderStatus.valueOf("PLACED");
		OrderStatus status1 = OrderStatus.DELIVERED;
		
		for(OrderStatus orderStatus : orderStatuses) {
			System.out.println(orderStatus);
		}
		
		System.out.println(status);
		System.out.println(status1);
		System.out.println(status.name() +" "+ status.ordinal() + " " + status.getDescription() + " " + status.getTerminal());	
	}
}


enum OrderStatus{
	
	PLACED("Order placed", false), //additional fields associated with enum constants
	CONFIRMED("Order confirmed", true),
	SHIPPED("Order shipped", false),
	DELIVERED("Order delivered", true),
	CANCELLED("Order cancelled", false);

	private final String description;
	private final boolean terminal;
	
	private OrderStatus(String description, boolean terminal) {
		this.description = description;
		this.terminal = terminal;
		
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getTerminal() {
		return terminal;
	}
}

//final class OrderStatus{
//	
//	private final String name;
//	private int ordinal;
//	
//    public static final OrderStatus PLACED = new OrderStatus("PLACED", 0);
//
//    public static final OrderStatus CONFIRMED = new OrderStatus("CONFIRMED", 1);
//
//    public static final OrderStatus SHIPPED = new OrderStatus("SHIPPED", 2);
//
//    public static final OrderStatus DELIVERED = new OrderStatus("DELIVERED", 1);
//
//    public static final OrderStatus CANCELLED = new OrderStatus("CANCELLED", 2);
//    
//    private static final OrderStatus[] array = {PLACED, CONFIRMED, SHIPPED, DELIVERED, CANCELLED};
//
//    private OrderStatus(String name, int ordinal) {
//        this.name = name;
//        this.ordinal = ordinal;
//    }
//    
//    public static OrderStatus[] values() {
//    	
//    	return array;
//    			
//    }
//    
//    public String name() {
//    	return this.name;
//    }
//    
//    public int ordinal() {
//    	return this.ordinal;
//    }
//    
//    public static OrderStatus valueOf(String name) {
//    	OrderStatus result= Arrays.stream(array)
//    			.filter(n -> name.equals(n.name))
//    			.findFirst()
//    			.orElse(null);
//    
//    	return result;
//    }
//    
//    @Override
//    public String toString() {
//    	return this.name;
//    }
//}



