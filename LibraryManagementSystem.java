import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Issued Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Check if the next input is an integer
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        library.addBook(new Book(title, author));
                        break;
                    case 2:
                        library.displayBooks();
                        break;
                    case 3:
                        System.out.print("Enter the title of the book to issue: ");
                        String issueTitle = scanner.nextLine();
                        library.issueBook(issueTitle);
                        break;
                    case 4:
                        System.out.print("Enter the title of the book to return: ");
                        String returnTitle = scanner.nextLine();
                        System.out.print("Enter the number of days late (0 if not late): ");
                        int daysLate = scanner.nextInt();
                        library.returnBook(returnTitle, daysLate);
                        break;
                    case 5:
                        library.displayIssuedBooks();
                        break;
                    case 6:
                        System.out.println("Exiting the Library Management System. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
}
