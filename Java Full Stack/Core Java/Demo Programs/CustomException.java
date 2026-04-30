package javaPrograms;

//Creating custom checked exception by extending the class from Exception class
//if you want to create a custom unchecked exception, extend the class from RuntimeException
class InsufficientFundsException extends Exception {
    
    // Constructor that accepts a custom message
    public InsufficientFundsException(double amountNeeded) {
        // Pass a formatted string to the parent 'Exception' class
        super("Transaction failed! You are short by: ₹" + amountNeeded);
    }
}

public class CustomException {
    private static double balance = 500.00;
    // throws is mandatory since it is a custom checked exception
    public static void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double missing = amount - balance;
            // Throwing our custom exception with specific data
            throw new InsufficientFundsException(missing);
        }
        balance -= amount;
        System.out.println("Withdrawal successful!");
    }

    public static void main(String[] args) {
        // handling the custom checked exception using try-catch
        try {
            withdraw(750.00); 
        } catch (InsufficientFundsException e) {
            // This will print the custom message we built in the constructor
            System.out.println(e); 
        }
    }
}
