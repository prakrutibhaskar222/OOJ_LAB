import java.util.Scanner;
class Books {
     private String name;
    private String author;
    private double price;
    private int num_pages;

    // Constructor to initialize the book details
    public Books(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNumPages() {
        return num_pages;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumPages(int num_pages) {
        this.num_pages = num_pages;
    }

    // toString method to display complete details
    @Override
    public String toString() {
        return "Book Name: " + name +
               "\nAuthor: " + author +
               "\nPrice: ₹" + price +
               "\nNumber of Pages: " + num_pages + "\n";
    }
}

class BookDemo 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Input number of books
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline character

        // Create an array of Books objects
        Books[] books = new Books[n];

        // Input details for each book
        for (int i = 0; i < n; i++) 
        {
            System.out.println("\nEnter details of Book " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Number of pages: ");
            int pages = sc.nextInt();
            sc.nextLine();  // Consume newline character

            // Create a Books object and store it in the array
            books[i] = new Books(name, author, price, pages);
        }

        // Display all book details
        System.out.println("\n--- Book Details ---");
        for (Books b : books) 
        {
            System.out.println(b.toString());
        }

        // Close the scanner
        sc.close();
    }

}