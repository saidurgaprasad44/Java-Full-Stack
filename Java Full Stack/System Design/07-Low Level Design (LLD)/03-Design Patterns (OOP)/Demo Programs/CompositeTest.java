package javaPrograms;

import java.util.List;
import java.util.ArrayList;

public class CompositeTest {

	public static void main(String[] args) {
		
		Composite computer = new Composite("computer");
		Composite cabinet = new Composite("cabinet");
		Composite peripheral = new Composite("peripheral");
		Composite mb = new Composite("mb");
		
		Component mouse = new Leaf("mouse", 500);
		Component monitor = new Leaf("monitor", 12000);
		Component keyboard = new Leaf("keyboard", 2000);
		Component hdd = new Leaf("hdd", 4000);
		Component ram = new Leaf("ram", 8000);
		Component cpu = new Leaf("cpu", 30000);
		
		computer.addComponent(cabinet);
		computer.addComponent(peripheral);
		
		cabinet.addComponent(hdd);
		cabinet.addComponent(mb);
		
		mb.addComponent(ram);
		mb.addComponent(cpu);
		
		peripheral.addComponent(mouse);
		peripheral.addComponent(monitor);
		peripheral.addComponent(keyboard);
		
		computer.showPrice();
		
	}

}

interface Component {
	
	public void showPrice();

}

class Leaf implements Component {
	
	int price;
	String name;
	
	public Leaf(String name, int price) {
		this.price = price;
		this.name = name;
	}
	public void showPrice() {
		System.out.println(name + " : " + price);
	}
}

class Composite implements Component{
	
	String name;
	List<Component> components = new ArrayList<>();
	
	public Composite(String name) {
		this.name = name;
	}
	
	public void addComponent(Component com) {
		components.add(com);
	}
	
	public void showPrice() {
		System.out.println(name);
		for(Component c : components) {
			c.showPrice();
		}
	}
}