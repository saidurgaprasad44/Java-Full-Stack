package javaPrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowVsThrowsDemo {

    // 'throws' is the warning: "Careful, this method might throw an exception!"
    public static void checkAge() throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int age = Integer.parseInt(br.readLine());
        if (age < 18 || age>50) {
            // 'throw' is the action: "I am officially creating an error right now!"
            throw new ArithmeticException("Access Denied: You must be at least 18.");
        } else {
            System.out.println("Access Granted!");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(); // Calling the method that warned us
        } catch (NumberFormatException | IOException e) {
            // Handling the manual exception we 'threw'
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}
