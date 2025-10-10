import java.util.*;

public class sgpa {
    public static int credits(int score) {
        int points;
        if (score > 90) {
            points = 10;
        } else if (score >= 80) {
            points = 9;
        } else if (score >= 78) {
            points = 8;
        } else if (score >= 60) {
            points = 7;
        } else if (score >= 50) {
            points = 6;
        } else {
            points = 0; // Failing grade
        }
        return points;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int credSum = 0;
        int pointSum = 0;
        double SGPA;

        System.out.println("Enter name and USN");
        String name = scan.nextLine();
        String USN = scan.nextLine();

        System.out.println("Enter number of subjects:");
        int a = scan.nextInt();

        int[] cred = new int[a];
        int[] marks = new int[a];

        for (int i = 0; i < a; i++) {
            System.out.println("Enter credits for subject " + (i + 1) + ":");
            cred[i] = scan.nextInt();
            credSum += cred[i];  // Fix here

            System.out.println("Enter marks obtained:");
            marks[i] = scan.nextInt();

            pointSum += credits(marks[i]) * cred[i];
        }

        // Calculate SGPA as float/double
        if (credSum == 0) {
            System.out.println("Total credits cannot be zero.");
        } else {
            SGPA = (double) pointSum / credSum;
            System.out.printf("SGPA = %.2f\n", SGPA);
        }

        scan.close();
    }
}
