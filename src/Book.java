import java.util.Scanner;

public class Book extends PrintedPublication {
    private int pageCount;

    public Book(String title, String author, int year, int pageCount) {
        super(title, author, year);
        try {
            if (pageCount <= 0) {
                throw new IllegalArgumentException("Page count must be greater than 0");
            }
            this.pageCount = pageCount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.pageCount = 0;
        }
    }

    public void show() {
        super.show();
        System.out.println("Page Count: " + pageCount);
    }

    public static Book createFromInput() {
        Scanner scanner = new Scanner(System.in);
        PrintedPublication printedPublication = PrintedPublication.createFromInput();
        int pageCount = 0;
        while (true) {
            try {
                System.out.print("Enter the page count: ");
                pageCount = Integer.parseInt(scanner.nextLine());
                if (pageCount <= 0) {
                    throw new IllegalArgumentException("Page count must be greater than 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid page count format. Page count should be an integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Book(printedPublication.getTitle(), printedPublication.getAuthor(), printedPublication.getYear(), pageCount);
    }

    public int getPageCount() {
        return pageCount;
    }
}
