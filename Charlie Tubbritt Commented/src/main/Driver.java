package main;

import models.*;
import utils.*;
import controllers.*;

/**
 * the driver class is our point of contact with the user
 * it serves to construct our visual elements, receive
 * user inputs and conduct some error checking.
 */
public class Driver {

    private LibrarySystemAPI library;

    /**
     * This is our constructor in instantiates library
     */
    public Driver() {
        library = new LibrarySystemAPI();
    }


    /**
     * This is our main method in the application,
     * it instantiates app and calls the run menu method
     *
     * @param args
     *
     */
    public static void main(String[] args) {
        Driver app = new Driver();
        app.runMenu();
    }

    /**
     * Displays the main menu and retrieves an int value from the user
     *
     * @return int
     */
    private int mainMenu() {
        int num;
        System.out.println("   Library Menu");
        System.out.println("----------------------");
        System.out.println("1)  Add Book");
        System.out.println("2)  Remove Book");
        System.out.println("3)  List all Books");
        System.out.println("4)  Display a book by ISBN");
        System.out.println("5)  Display a book by Title");
        System.out.println("6)  Display a book by Author");
        System.out.println("7)  Display all books by ISBN");
        System.out.println("8)  Display all books by Title");
        System.out.println("9)  Display all books by Author");
        System.out.println("10) Search all books by a Key Word");
        System.out.println("11) List all books in Alphabetical Order");
        System.out.println("12) Show edition of each Book");
        System.out.println("13) Save Details");
        System.out.println("14) Load Details");
        System.out.println("0) Exit");
        num = ScannerInput.readNextInt("==>>");
        return num;
    }

    /**
     * Runs the main menu loop, which manages user selection
     */
    private void runMenu() {
        int option = mainMenu();

        while (option != 0) {

            switch (option) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> displayAllBooks();
                case 4 -> getBookByIsbn();
                case 5 -> getBookByTitle();
                case 6 -> getBookByAuthor();
                case 7 -> getAllBooksByIsbn();
                case 8 -> getAllBooksByTitle();
                case 9 -> getAllBooksByAuthor();
                case 10 -> searchBookByWord();
                case 11 -> showInAlphabeticalOrder();
                case 12 -> showEdition();
                case 13 -> saveData();
                case 14 -> loadData();
                default -> System.out.println("Invalid option entered: " + option);
            }

            ScannerInput.readNextLine("\nPress enter key to continue...");
            option = mainMenu();
        }

        System.out.println("Exiting the program");
        System.exit(0);
    }

    /**
     * Takes in values from the user and uses those values to create and
     * add a book object to the system
     */
    private void addBook() {
        System.out.println("""
                Which book type would you like to add: 
                1. eBook
                2. Fiction Book
                3. Geography Book
                4. History Book
                """);
        int choice = ScannerInput.readNextInt("Enter your choice =>");
        switch (choice) {
            case 1 -> {
                boolean interactivity = false;
                System.out.println("Enter ebook Details: ");
                String isbn = ScannerInput.readNextLine("ISBN: ");
                String title = ScannerInput.readNextLine("Title: ");
                String author = ScannerInput.readNextLine("Author: ");
                int numOfPages = ScannerInput.readNextInt("Number of Pages: ");
                char interactivityIn = ScannerInput.readNextChar("Is the book interactive (y or n only: ) ");
                if (interactivityIn == 'Y' || interactivityIn == 'y') {
                    interactivity = true;
                } else if (interactivityIn == 'N' || interactivityIn == 'n') {
                    interactivity = false;
                } else {
                    throw new IllegalArgumentException("Invalid input, interactivity set to No");
                }
                Ebook eBook = new Ebook(isbn, title, author, numOfPages, interactivity);
                library.addBook(eBook);

            }
            case 2 -> {
                System.out.println("Enter Fiction Book Details: ");
                String isbn = ScannerInput.readNextLine("ISBN: ");
                String title = ScannerInput.readNextLine("Title: ");
                String author = ScannerInput.readNextLine("Author: ");
                int numOfPages = ScannerInput.readNextInt("Number of Pages: ");
                int yearPublished = ScannerInput.readNextInt("Year Published: ");
                String genre = ScannerInput.readNextLine("Genre: ");
                FictionBook fBook = new FictionBook(isbn, title, author, numOfPages, yearPublished, genre);
                library.addBook(fBook);
            }
            case 3 -> {
                System.out.println("Enter Geography Book Details: ");
                String isbn = ScannerInput.readNextLine("ISBN: ");
                String title = ScannerInput.readNextLine("Title: ");
                String author = ScannerInput.readNextLine("Author: ");
                int numOfPages = ScannerInput.readNextInt("Number of Pages: ");
                int yearPublished = ScannerInput.readNextInt("Year Published: ");
                String region = ScannerInput.readNextLine("Region: ");
                System.out.println("""
                                                
                        Element Choices: 
                        1- The world in Spatial Terms
                        2- Places and Regions
                        3- Physical System
                        4- Human Systems
                        """);
                int element = ScannerInput.readNextInt("Element: ");
                Geography geoBook = new Geography(isbn, title, author, numOfPages, yearPublished, region, element);
                library.addBook(geoBook);
            }
            case 4 -> {
                System.out.println("Enter History Book Details: ");
                String isbn = ScannerInput.readNextLine("ISBN: ");
                String title = ScannerInput.readNextLine("Title: ");
                String author = ScannerInput.readNextLine("Author: ");
                int numOfPages = ScannerInput.readNextInt("Number of Pages: ");
                int yearPublished = ScannerInput.readNextInt("Year Published: ");
                String topic = ScannerInput.readNextLine("Topic: ");
                String era = ScannerInput.readNextLine("Era: ");
                History historyBook = new History(isbn, title, author, numOfPages, yearPublished, topic, era);
                library.addBook(historyBook);
            }
        }
    }

    /**
     * Prompting the user for a book index and removes the book from the library system.
     */
    private void removeBook() {
        library.listOfBooks();
        if (library.numberOfbooks() > 0) {

            int index = ScannerInput.readNextInt("Index of the book to delete: ");
            if (library.removeBook(index)) {
                System.out.println("Book removed successfully");
            } else {
                System.out.println("Unable to locate book in library system");
            }
        } else {
            System.out.println("There are no books in the list");
        }
    }

    /**
     * Displays all books in the library system.
     */
    private void displayAllBooks() {
        if (library.numberOfbooks() > 0) {
            System.out.println(library.listOfBooks());
        } else {
            System.out.println("There are no books in the list");
        }
    }

    /**
     * Retrieves a book by its ISBN and displays it to the user.
     */
    private void getBookByIsbn() {
        if (library.numberOfbooks() > 0) {
            String isbn = ScannerInput.readNextLine("ISBN of Book: ");
            if (library.getBookByIsbn(isbn) != null) {
                System.out.println("Book Found: \n");
                System.out.println(library.getBookByIsbn(isbn));
            }
        } else {
            System.out.println("There are no books in the Library");
        }
    }

    /**
     * Retrieves a book by its Title and displays it to the user.
     */
    private void getBookByTitle() {
        if (library.numberOfbooks() > 0) {
            String title = ScannerInput.readNextLine("Title of Book: ");
            if (library.getBookByTitle(title) != null) {
                System.out.println("Book Found: \n");
                System.out.println(library.getBookByTitle(title).toString());
            }
        } else {
            System.out.println("There are no books in the Library");
        }
    }


    /**
     * Retrieves a book by its Author and displays it to the user.
     */
    private void getBookByAuthor() {
        if (library.numberOfbooks() > 0) {
            String author = ScannerInput.readNextLine("Author of Book: ");
            if (library.getBookByAuthor(author) != null) {
                System.out.println("Book Found: \n");
                System.out.println(library.getBookByTitle(author).toString());
            }
        } else {
            System.out.println("There are no books in the Library");
        }
    }

    /**
     * Retrieves all books with a specific ISBN and displays them to the user.
     */
    private void getAllBooksByIsbn() {
        if (library.numberOfbooks() > 0) {
            String isbn = ScannerInput.readNextLine("ISBN of Books: ");
            String listOfBooks = library.getBooksByIsbn(isbn);
            if (listOfBooks != "") {
                System.out.println("Books found: \n");
                System.out.println(listOfBooks);
            } else {
                System.out.println("There are no books with that ISBN");
            }
        } else {
            System.out.println("There are no books in the library");
        }
    }

    /**
     * Retrieves all books with a specific title and displays them to the user.
     */
    private void getAllBooksByTitle() {
        if (library.numberOfbooks() > 0) {
            String title = ScannerInput.readNextLine("Title of Books: ");
            String listOfBooks = library.getBooksByTitle(title);
            if (listOfBooks != "") {
                System.out.println("Books found: \n");
                System.out.println(listOfBooks);
            } else {
                System.out.println("There are no books with that Title");
            }
        } else {
            System.out.println("There are no books in the library");
        }
    }

    /**
     * Retrieves all books by a specific Author and displays them to the user.
     */
    private void getAllBooksByAuthor() {
        if (library.numberOfbooks() > 0) {
            String author = ScannerInput.readNextLine("Author of Books: ");
            String listOfBooks = library.getBooksByAuthor(author);
            if (listOfBooks != "") {
                System.out.println("Books found: \n");
                System.out.println(listOfBooks);
            } else {
                System.out.println("There are no books by that Author");
            }
        } else {
            System.out.println("There are no books in the library");
        }
    }

    /**
     * Searches for books containing a specific keyword in their titles and displays them to the user.
     */
    private void searchBookByWord() {
        if (library.numberOfbooks() > 0) {
            String keyWord = ScannerInput.readNextLine("Enter Key Search Term: ");
            System.out.println(library.searchWord(keyWord));
        } else {
            System.out.println("There are no books in the library");
        }
    }

    /**
     * Displays titles of all books in alphabetical order.
     */
    private void showInAlphabeticalOrder(){
        if (library.numberOfbooks() > 0){
            System.out.println(library.alphabeticalOrder());
        }else{
            System.out.println("There are no books in the library");
        }
    }

    /**
     * Displays the edition of each book in the library system.
     */
    private void showEdition(){
            System.out.println(library.showEditionOfEachBook());
    }

    /**
     * Saves all Objects entered
     */
    private void saveData() {
        try {
            LibrarySystemAPI.save();
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e);
        }
    }

    /**
     * Loads all Objects Saved
     */
    private void loadData() {
        try {
            LibrarySystemAPI.load();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
    }
}
