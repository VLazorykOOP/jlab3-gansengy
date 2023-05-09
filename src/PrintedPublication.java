import java.util.Scanner;

public class PrintedPublication {
    private String title;
    private String author;
    private int year;

    public PrintedPublication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        try {
            this.year = year;
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format. Year should be an integer.");
        }
    }

    public void show() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
    }

    public static PrintedPublication createFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the year: ");
        int year = 0;
        try {
            year = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format. Year should be an integer.");
        }
        return new PrintedPublication(title, author, year);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
