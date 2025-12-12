import java.util.*;

// Custom exception for invalid ages
class WrongAge extends Exception {
    public WrongAge(String msg) {
        super(msg);
    }
}

// Base Class
class Father {
    int fatherAge;

    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative!");
        }
        this.fatherAge = age;
    }
}

// Derived Class
class Son extends Father {
    int sonAge;

    Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge);  // Call Father constructor

        if (sonAge < 0) {
            throw new WrongAge("Son's age cannot be negative!");
        }

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to Father's age!");
        }

        this.sonAge = sonAge;
    }
}

// Main class to test
public class ExceptionDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Father's age: ");
            int f = sc.nextInt();

            System.out.print("Enter Son's age: ");
            int s = sc.nextInt();

            Son obj = new Son(f, s);

            System.out.println("\nValid ages entered.");
            System.out.println("Father's Age: " + obj.fatherAge);
            System.out.println("Son's Age: " + obj.sonAge);

        } catch (WrongAge e) {
            System.out.println("\nException Caught: " + e.getMessage());
        }
    }
}