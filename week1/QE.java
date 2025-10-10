import java.util.Scanner;

public class QE {
    public static void main(String[] args) {
        double a, b, c, d, r1, r2, real, imag;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        a = scan.nextDouble();

        System.out.print("Enter coefficient b: ");
        b = scan.nextDouble();

        System.out.print("Enter coefficient c: ");
        c = scan.nextDouble();

        d = b*b - 4*a*c;

        if (a == 0) {
            System.out.println("Not a quadratic equation.");
        } else if (d > 0) {
            r1 = (-b + Math.sqrt(d)) / (2*a);
            r2 = (-b - Math.sqrt(d)) / (2*a);
            System.out.println("Roots are real and unequal: " + r1 + " , " + r2);
        } else if (d == 0) {
            r1 = -b / (2*a);
            System.out.println("Roots are real and equal: " + r1);
        } else {
            real = -b / (2*a);
            imag = Math.sqrt(-d) / (2*a);
            System.out.println("Roots are complex: " + real + " + " + imag + "i , " + real + " - " + imag + "i");
        }

        scan.close();
    }
}