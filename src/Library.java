import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {
    private Map<String,Book> bookCollection;//Key : Book Id, Value:Book Object
    private static final Scanner scanner = new Scanner(System.in);
    public Library() {
        bookCollection = new HashMap<String, Book>();
    }
    public static Scanner getScanner() {
        return scanner;
    }
    //Adding a book to the collection
    public void addBook(){
        System.out.println("\n Adding a new book");
        System.out.println("Enter Book Id: ");
        String BookId = scanner.nextLine().trim();
        if(bookCollection.containsKey(BookId)){
            System.out.println("\n Book already exists! Try Again");
            return;
        }
        System.out.println("Enter Title: ");
        String title = scanner.nextLine().trim();
        System.out.println("Enter Author: ");
        String author = scanner.nextLine().trim();
        System.out.println("Enter Genre: ");
        String genre = scanner.nextLine().trim();
        System.out.println("Enter Availability(Available/Checked Out): ");
        String availability = scanner.nextLine().trim();
        if(title.isEmpty() || author.isEmpty() ){
            System.out.println("\n Title and Author cannot be empty");
            return;
        }
        if(!availability.equalsIgnoreCase("Available") && !availability.equalsIgnoreCase("CheckedOut")){
            System.out.println("Invalid availability status! choose Available/CheckedOut");
            return;
        }
        bookCollection.put(BookId , new Book(BookId,title,author,genre,availability));
        System.out.println("\n Book added successfully");
    }
    //View All Books
    public void viewAllBooks(){
        if(bookCollection.isEmpty()){
            System.out.println("\n No books found");
        }
        else{
            System.out.println("Library Collection: ");
            for(Book book : bookCollection.values()){
                System.out.println(book);
            }
        }
    }
    //Search for a Book by Id or Title
    public void searchBook(){
        System.out.println("Enter Book Id or Title to search: ");
        String searchBook = scanner.nextLine().trim();
        for(Book book : bookCollection.values()){
            if(book.getBookId().equalsIgnoreCase(searchBook) || book.getTitle().equalsIgnoreCase(searchBook)){
                System.out.println("Book found " + book);
                return;
            }
        }
        System.out.println("Book Not Found");
    }
    //Update Book Details
    public void updateBook(){
        System.out.println("Enter Book Id to update: ");
        String bookId = scanner.nextLine().trim();
        if(!bookCollection.containsKey(bookId)){
            System.out.println("Book not found");
            return;
        }
        Book book = bookCollection.get(bookId);
        System.out.print("Enter New Title (Leave blank to keep the same): ");
        String newTitle = scanner.nextLine().trim();
        if (!newTitle.isBlank()) book.setTitle(newTitle);

        System.out.print("Enter New Author (Leave blank to keep the same): ");
        String newAuthor = scanner.nextLine().trim();
        if (!newAuthor.isBlank()) book.setAuthor(newAuthor);

        System.out.print("Enter New Genre (Leave blank to keep the same): ");
        String newGenre = scanner.nextLine().trim();
        if (!newGenre.isBlank()) book.setGenre(newGenre);

        System.out.print("Enter New Availability (Available/Checked Out): ");
        String newAvailability = scanner.nextLine().trim();
        if (newAvailability.equalsIgnoreCase("Available") || newAvailability.equalsIgnoreCase("Checked Out")) {
            book.setAvailabilityStatus(newAvailability);
        }

        System.out.println("Book updated successfully!");
    }

    //Delete a Book
    public void deleteBook(){
        System.out.println("Enter Book Id to delete: ");
        String bookId = scanner.nextLine().trim();
        if(!bookCollection.containsKey(bookId)){
            System.out.println("Book not found");
        }
        else{
            bookCollection.remove(bookId);
            System.out.println("Book deleted successfully!");
        }
    }
    //Exit a System
    public void exitSystem() {
        System.out.println("\n Exiting Library Management System... Goodbye!");
        scanner.close();
    }
}
