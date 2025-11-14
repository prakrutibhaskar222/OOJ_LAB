import java.util.*;
import CIE.*;
import SEE.*;

public class FinalMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student s[] = new Student[n];
        Internals in[] = new Internals[n];
        External ex[] = new External[n];

        // Input student details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of student " + (i+1));

            System.out.print("USN: ");
            String usn = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int im[] = new int[5];
            int em[] = new int[5];

            System.out.println("Enter 5 internal marks: ");
            for (int j = 0; j < 5; j++)
                im[j] = sc.nextInt();

            System.out.println("Enter 5 SEE marks: ");
            for (int j = 0; j < 5; j++)
                em[j] = sc.nextInt();

            s[i] = new Student(usn, name, sem);
            in[i] = new Internals(im);
            ex[i] = new External(usn, name, sem, em);
        }

        // Display final marks
        System.out.println("\n----- FINAL MARKS OF STUDENTS -----");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i+1));
            System.out.println("USN: " + s[i].usn);
            System.out.println("Name: " + s[i].name);
            System.out.println("Semester: " + s[i].sem);

            System.out.println("Course\tFinal Marks");
            for (int j = 0; j < 5; j++) {
                int finalMarks = in[i].internalMarks[j] + (ex[i].seeMarks[j] / 2);
                System.out.println((j+1) + "\t" + finalMarks);
            }
        }
        sc.close();
    }
}
