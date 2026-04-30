package javaPrograms;

import java.util.ArrayList;

class AllTypes<T> { //T can be of any class type
	
	private T value;
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void showType() {
		System.out.println(this.getValue().getClass().getName());
	}
	
	public void demoMethod(T a) {
		System.out.println(a.getClass().getName());
	}
	
	public void demoIntegerMethod(ArrayList<Integer> a) { //generics on a method that is restricted to only Integer

	}
	
}

class NumberTypes<T extends Number> { //restricting T to be of only Number and its descendants i.e., Integer, Float etc.
	
	
	public void demoAllNumberMethod(ArrayList<? extends T> a) { //restricting ? to be of only T class types that extend T and its descendants i.e., Integer, Float etc.

	}
}

public class GenericsDemo {
	public static void main(String[] args) {
		AllTypes<String> at = new AllTypes<>();
		at.setValue("Sai");
		at.showType();
		at.demoMethod("Vaishu"); //allows only String as 'at' is created with String type
		at.demoIntegerMethod(new ArrayList<Integer>()); //doesn't allow any other types than Integer
		NumberTypes<Number> nt = new NumberTypes<>();
		nt.demoAllNumberMethod(new ArrayList<Number>()); //doesn't allow any other types than Number and its descendants
		
	}
}
