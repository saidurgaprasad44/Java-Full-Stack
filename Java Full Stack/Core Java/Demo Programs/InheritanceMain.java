package javaPrograms;


class A{
	public A() {
		System.out.println("in A");
	}
	public A(String s) {
		System.out.println("this is parameterised constructor of A " + s);
	}
	public void greet() {
		System.out.println("hello world, i am a developer");
	}
}

class B extends A{
	public B() {
		super("message"); //calls parent class's parameterized constructor
		System.out.println("in B");
	}
	public B(String s) {
		System.out.println("this is parameterised constructor of B " + s);
	}
	public void greet() {
		super.greet(); //calls parent class's version of greet()
		System.out.println("hello world, i am a java developer");
	}
	public void hello() {
		System.out.println("this is a new method in c");
	}
}
public class InheritanceMain {

	public static void main(String[] args) {
		A a = new B(); //Sees what is available in A, initializes B
		a.greet(); //executes greet() from B
		//a.hello(); //Compilation error, since A doesn't have hello()
	}

}
