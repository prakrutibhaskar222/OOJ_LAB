import java.util.Scanner;

abstract class Shape{
    int breadth,width;
    public void printArea(int a,int b){

    }

}
class Rectangle extends Shape{
    public void printArea(int a,int b){
        System.out.println("AREA :"+ (a*b));
    }

}
class Triangle extends Shape{
    public void printArea(int a,int b){
        System.out.println("AREA :"+ (0.5*a*b));
    }

}
class Circle extends Shape{
    public void printArea(int a,int b){
        System.out.println("AREA :"+ (a*b*b));
    }

}
public class AREA {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);

        System.out.print("Enter 1)Rectangle 2)Triangle 3)Circle ");
        int choice = scan.nextInt();
        int a ,b;
        switch (choice) {
            case 1:
                Rectangle r1=new Rectangle();
                System.out.print("Enter breadth ");
                a = scan.nextInt();
                System.out.print("Enter length ");
                 b = scan.nextInt();
                r1.printArea(a,b);
                break;
            case 2:
                Triangle t1=new Triangle();
                System.out.print("Enter height ");
                a = scan.nextInt();
                System.out.print("Enter base ");
                b = scan.nextInt();
                t1.printArea(a,b);
                break;
            case 3:
                Circle c1=new Circle();
                System.out.print("Enter PI value ");
                a = scan.nextInt();
                System.out.print("Enter radius ");
                b = scan.nextInt();
                c1.printArea(a,b);
                break;
            default:
                System.out.println("Wrong choice");
                break;
        }

    }
    

    
}
