package javaPrograms;

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("--- CONSTRUCTOR CHAINING ---");
        Animal myPet = new Dog(); 

        System.out.println("\n--- METHOD OVERRIDING (Runtime / Dynamic Dispatch) ---");
        myPet.reproduce(); 

        System.out.println("\n--- VARIABLE HIDING (Compile-time) ---");
        System.out.println("Reference as Animal: " + myPet.type);
        System.out.println("Reference as Mammal: " + ((Mammal) myPet).type);
        System.out.println("Reference as Dog:    " + ((Dog) myPet).type);

        System.out.println("\n--- STATIC METHOD HIDING (Compile-time / Static Dispatch) ---");
        // 1. Calling via object references (Resolved by reference type, NOT actual object)
        myPet.getClassification();             // Calls Animal's version
        ((Mammal) myPet).getClassification();  // Calls Mammal's version
        ((Dog) myPet).getClassification();     // Calls Dog's version

        // 2. Best practice: Calling directly via Class names
        System.out.println("\n--- CALLING STATIC METHODS VIA CLASS NAMES ---");
        Animal.getClassification();
        Mammal.getClassification();
        Dog.getClassification();
    }
}


class Animal {
    // Property to demonstrate variable hiding
    String type = "General Animal";

    // Constructor 1
    public Animal() {
        System.out.println("1. Animal constructor called.");
    }

    // Static method to demonstrate method hiding (Compile-time dispatch)
    public static void getClassification() {
        System.out.println("Static Classification: Kingdom Animalia");
    }

    public void eat() {
        System.out.println("Eating.");
    }

    public void reproduce() {
        System.out.println("Reproducing to create offspring.");
    }
}

class Mammal extends Animal {
    // Hides Animal.type
    String type = "Warm-blooded Mammal";

    // Constructor 2
    public Mammal() {
        super();
        System.out.println("2. Mammal constructor called.");
    }

    // Hides Animal.getClassification() (Note: @Override annotation is NOT allowed here)
    public static void getClassification() {
        System.out.println("Static Classification: Class Mammalia");
    }

    public void produceMilk() {
        System.out.print("producing milk");
    }

    @Override
    public void reproduce() {
        System.out.print("Giving live birth and ");
        this.produceMilk();
        System.out.println();
    }
}

class Dog extends Mammal {
    // Hides Mammal.type and Animal.type
    String type = "Domestic Dog";

    // Constructor 3
    public Dog() {
        super();
        System.out.println("3. Dog constructor called.");
    }

    // Hides Mammal.getClassification() and Animal.getClassification()
    public static void getClassification() {
        System.out.println("Static Classification: Species Canis lupus familiaris");
    }

    public void bark() {
        System.out.print(", barking bow wow ");
    }

    @Override
    public void reproduce() {
        System.out.print("Giving live birth to a litter of puppies, ");
        super.produceMilk();
        this.bark();
        System.out.println("and nursing them.");
    }
}
