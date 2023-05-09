import java.util.Scanner;
public class Magazine extends PrintedPublication {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        try {
            this.issueNumber = issueNumber;
        } catch (NumberFormatException e) {
            System.out.println("Invalid issue number format: " + e.getMessage());
        }
    }

    public void show() {
        super.show();
        System.out.println("Issue Number: " + issueNumber);
    }

    public static Magazine createFromInput() {
        Scanner scanner = new Scanner(System.in);
        PrintedPublication printedPublication = PrintedPublication.createFromInput();
        int issueNumber = 0;
        try {
            issueNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid issue number format. Issue number should be an integer.");
        }
        return new Magazine(printedPublication.getTitle(), printedPublication.getAuthor(), printedPublication.getYear(), issueNumber);
    }
}
