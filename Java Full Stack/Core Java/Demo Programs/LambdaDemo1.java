package javaPrograms;

public class LambdaDemo1 {

	public static void main(String[] args) {
		One o = (a, b) -> {
			System.out.print("The sum is: ");
			return a+b;
		};
		System.out.println(o.method(10, 20));
		
		Two t = () -> "Hello world";
		System.out.println(t.method());
	}
}

interface One {
	public int method(int a, int b);
}

interface Two {
	public String method();
}
