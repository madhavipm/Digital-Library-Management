public class LibraryApp {
    private  Library library;
    public LibraryApp(Library library) {
        this.library = library;
    }
    public LibraryApp(){

    }
    public void run() {
        while (true) {
            displayMenu();
            int choice = Library.getScanner().nextInt();
            Library.getScanner().nextLine(); // Consume newline

            switch (choice) {
                case 1 -> library.addBook();
                case 2 -> library.viewAllBooks();
                case 3 -> library.searchBook();
                case 4 -> library.updateBook();
                case 5 -> library.deleteBook();
                case 6 -> {
                    library.exitSystem();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    private void displayMenu() {
        System.out.println("\n📚 Library Management System");
        System.out.println("1. Add a Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book");
        System.out.println("4. Update Book");
        System.out.println("5. Delete Book");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }
}
