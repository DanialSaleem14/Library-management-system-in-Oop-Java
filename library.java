import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;
    private List<Book> issuedBooks; // Added list for issued books
    private static final double LATE_RETURN_CHARGE = 1.5;
    private static final int ISSUE_TIME_LIMIT_DAYS = 14;

    public Library() {
        this.books = new ArrayList<>();
        this.issuedBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    issuedBooks.add(book); // Add the issued book to the issuedBooks list
                    System.out.println("Book issued: " + book);
                    System.out.println("Return within " + ISSUE_TIME_LIMIT_DAYS + " days.");
                    return;
                } else {
                    System.out.println("Book is not available for issue.");
                    return;
                }
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public void returnBook(String title, int daysLate) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    issuedBooks.remove(book); // Remove the returned book from the issuedBooks list
                    double lateCharge = daysLate > 0 ? LATE_RETURN_CHARGE * daysLate : 0;
                    System.out.println("Book returned: " + book);
                    if (lateCharge > 0) {
                        System.out.println("Late return charge: $" + lateCharge);
                    }
                    return;
                } else {
                    System.out.println("Book is not issued, cannot be returned.");
                    return;
                }
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public void displayIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books are currently issued.");
        } else {
            System.out.println("Issued Books:");
            for (Book book : issuedBooks) {
                System.out.println(book);
            }
        }
    }
}
