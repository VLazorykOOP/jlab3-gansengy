import java.util.Scanner;
public class Main {

    public static void FirstTask(){
        Scanner scanner = new Scanner(System.in);
        int numPublications = 0;
        while (true) {
            try {
                System.out.print("Enter the number of books: ");
                numPublications = Integer.parseInt(scanner.nextLine());
                if (numPublications <= 0) {
                    throw new IllegalArgumentException("Number of publications must be greater than 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter an integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        PrintedPublication[] publications = new PrintedPublication[numPublications];
        for (int i = 0; i < numPublications; i++) {
            System.out.print("Enter the type of publication (1 = PrintedPublication, 2 = Book, 3 = Magazine, 4 = Textbook): ");
            int type = 0;
            while (true) {
                try {
                    type = Integer.parseInt(scanner.nextLine());
                    if (type < 1 || type > 4) {
                        throw new IllegalArgumentException("Invalid publication type. Please enter a number between 1 and 4.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input format. Please enter an integer.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            switch (type) {
                case 1:
                    publications[i] = PrintedPublication.createFromInput();
                    break;
                case 2:
                    publications[i] = Book.createFromInput();
                    break;
                case 3:
                    publications[i] = Magazine.createFromInput();
                    break;
                case 4:
                    publications[i] = Textbook.createFromInput();
                    break;
            }
        }
        System.out.println("Publications:");
        for (PrintedPublication publication : publications) {
            publication.show();
            System.out.println();
        }
    }

    public static void SecondTask(){
        Pair[] pairs = new Pair[4];

        pairs[0] = new Complex(2, 3);
        pairs[1] = new Complex(-1, 2);
        pairs[2] = new Rational(1, 2);
        pairs[3] = new Rational(3, 2);

        // Test addition
        Pair result = pairs[0].add(pairs[1]);
        System.out.println(pairs[0] + " + " + pairs[1] + " = " + result);
        result = pairs[2].add(pairs[3]);
        System.out.println(pairs[2] + " + " + pairs[3] + " = " + result);

        // Test subtraction
        result = pairs[0].subtract(pairs[1]);
        System.out.println(pairs[0] + " - " + pairs[1] + " = " + result);
        result = pairs[2].subtract(pairs[3]);
        System.out.println(pairs[2] + " - " + pairs[3] + " = " + result);

        // Test multiplication
        result = pairs[0].multiply(pairs[1]);
        System.out.println(pairs[0] + " * " + pairs[1] + " = " + result);
        result = pairs[2].multiply(pairs[3]);
        System.out.println(pairs[2] + " * " + pairs[3] + " = " + result);
    }

    public static void ThirdTask(){
        Pair1[] pairs = new Pair1[4];

        pairs[0] = new Complex1(2, 3);
        pairs[1] = new Complex1(-1, 2);
        pairs[2] = new Rational1(3, 4);
        pairs[3] = new Rational1(2, 5);

        // Test addition
        Pair1 result = pairs[0].add(pairs[1]);
        System.out.println(pairs[0] + " + " + pairs[1] + " = " + result);
        result = pairs[2].add(pairs[3]);
        System.out.println(pairs[2] + " + " + pairs[3] + " = " + result);

        // Test subtraction
        result = pairs[0].subtract(pairs[1]);
        System.out.println(pairs[0] + " - " + pairs[1] + " = " + result);
        result = pairs[2].subtract(pairs[3]);
        System.out.println(pairs[2] + " - " + pairs[3] + " = " + result);

        // Test multiplication
        result = pairs[0].multiply(pairs[1]);
        System.out.println(pairs[0] + " * " + pairs[1] + " = " + result);
        result = pairs[2].multiply(pairs[3]);
        System.out.println(pairs[2] + " * " + pairs[3] + " = " + result);
    }
    public static void main(String[] args) {
        System.out.println("Java Lab 3");

        char answer;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. First task");
            System.out.println("2. Second task");
            System.out.println("3. Third task");
            System.out.println("E. Exit\n");
            System.out.print("Choose an option:");

            answer = scanner.nextLine().charAt(0);

            switch (answer) {
                case '1': FirstTask();
                    break;
                case '2': SecondTask();
                    break;
                case '3': ThirdTask();
                    break;
                case 'e':
                case 'E':
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (answer != 'e' && answer != 'E');
    }
}
