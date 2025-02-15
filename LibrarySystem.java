import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            book.displayBookInfo();
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title) {
        Book book = findBook(title);
        if (book != null && book.borrowBook()) {
            System.out.println("You have borrowed: " + title);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null) {
            book.returnBook();
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("Book not found.");
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Java Programming", "James Gosling");
        Book book2 = new Book("Python Basics", "Guido van Rossum");

        library.addBook(book1);
        library.addBook(book2);

        library.displayBooks();

        library.borrowBook("Java Programming");
        library.displayBooks();

        library.returnBook("Java Programming");
        library.displayBooks();
    }
}
