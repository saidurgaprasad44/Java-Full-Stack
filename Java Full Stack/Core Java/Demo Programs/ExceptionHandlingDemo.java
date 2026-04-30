package javaPrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionHandlingDemo {
	
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		try {
			i=Integer.parseInt(br.readLine());
			int k=10/i;
			System.out.println(k);
		}
		// the first triggered exception will be caught from the below multiple catch blocks
		catch(NumberFormatException | IOException e) { // any one exception from (NumberFormatException, IOException) can be caught
			System.out.println("Enter only numbers: " + e.getMessage());
		}
		catch(ArithmeticException e) {
			System.out.println("Cannot divide by zero: " + e.getMessage());
		}
		finally {
			System.out.println("Bye");
		}
	}

}
