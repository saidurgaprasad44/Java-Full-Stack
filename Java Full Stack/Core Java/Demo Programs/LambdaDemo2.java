package javaPrograms;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo2 {

	public static void main(String[] args) {
		
		//Implementing built-in interfaces using lambda expressions 
		Function<String, Integer> f = s -> s.length();
		System.out.println(f.apply("Vaishnavi"));
		
		Predicate<String> p = s -> s.contains("Prabha");
		System.out.println(p.test("Prabhavathi"));

		Consumer<String> c = s -> System.out.println(s);
		c.accept("Sai");
		
		Supplier<String> s = () -> "Priyanka and Loki";
		System.out.println(s.get());
		
		
	}

}
