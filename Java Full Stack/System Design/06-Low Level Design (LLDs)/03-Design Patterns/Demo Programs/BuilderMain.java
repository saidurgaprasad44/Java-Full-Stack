package javaPrograms;

public class BuilderMain {

	public static void main(String[] args) {
		
		//Need to pass all the parameters & follows the sequence while setting the values
		Phone p1 = new Phone("windows 10", 16, "intel i5 8th gen", 15.2, 7000);
		
		//You can set the desired parameters and the sequence also doesn't matter
		Phone p2 = new PhoneBuilder().setProcessor("intel i5 8th gen").setRam(16).getPhone();
		System.out.println(p1.toString());
		System.out.println(p2.toString());

	}

}

class PhoneBuilder {
	private String os;
	private int ram;
	private String processor;
	private double screensize;
	private int battery;
	
	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}
	public PhoneBuilder setRam(int ram) {
		this.ram = ram;
		return this;
	}
	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}
	public PhoneBuilder setScreensize(double screensize) {
		this.screensize = screensize;
		return this;
	}
	public PhoneBuilder setBattery(int battery) {
		this.battery = battery;
		return this;
	}
	
	public Phone getPhone() {
		return new Phone(os, ram, processor, screensize, battery);
	}
}

class Phone {
	private String os;
	private int ram;
	private String processor;
	private double screensize;
	private int battery;
	
	public Phone(String os, int ram, String processor, double screensize, int battery) {
		super();
		this.os = os;
		this.ram = ram;
		this.processor = processor;
		this.screensize = screensize;
		this.battery = battery;
	}

	@Override
	public String toString() {
		return "Phone [os=" + os + ", ram=" + ram + ", processor=" + processor + ", screensize=" + screensize
				+ ", battery=" + battery + "]";
	}
	
}
