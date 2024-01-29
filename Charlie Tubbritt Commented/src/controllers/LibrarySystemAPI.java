package controllers;

import models.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import utils.iReading;

import java.util.Collections;

public class LibrarySystemAPI {

    private static ArrayList<Book> allBooks;
    HashMap<String, Book> booksByIsbn;
    HashMap<String, Book> booksByAuthor;
    HashMap<String, Book> booksByTitle;


    /**
     *  This is the constructor for the LibrarySystemAPI
     *  it instantiates our allBooks arrayList, and 3
     *  HashMaps
     */
    public LibrarySystemAPI() {
        allBooks = new ArrayList<Book>();
        booksByIsbn = new HashMap<String, Book>();
        booksByAuthor = new HashMap<String, Book>();
        booksByTitle = new HashMap<String, Book>();
    }

    /**
     * Adds a book to the library system and adds the appropriate
     * values to their respective Hashmaps.
     *
     * @param bookIn
     */
    public void addBook(Book bookIn) {
        allBooks.add(bookIn);
        booksByIsbn.put(bookIn.getIsbn(), bookIn);
        booksByTitle.put(bookIn.getTitle(), bookIn);
        booksByAuthor.put(bookIn.getAuthor(), bookIn);
    }

    /**
     * Removes a book from the library system and removes the appropriate
     * values to their respective Hashmaps.
     * @param index
     * @return boolean
     */
    public boolean removeBook(int index) {
        if (index >= 0 && index < allBooks.size()) {
            Book removedBook = allBooks.remove(index);

            booksByIsbn.remove(removedBook.getIsbn());
            booksByTitle.remove(removedBook.getTitle());
            booksByAuthor.remove(removedBook.getAuthor());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of books in the allBooks Array
     *
     * @return int
     */
    public int numberOfbooks() {
        return allBooks.size();
    }

    /**
     * Returns a string representation of all the books in the library system.
     *
     * @return String
     */
    public String listOfBooks() {
        int index = 0;
        String listOfBooks = "";
        if (allBooks.isEmpty()) {
            return "There are no books stored.";
        } else {
            for (Book placeholder : allBooks) {
                listOfBooks += "\n" + index + ": " + placeholder.toString();
                index++;
            }
            return listOfBooks;
        }
    }

    /**
     * Returns a string representation of all the NonFiction books in the library system.
     *
     * @return String
     */
    public String showNonFictionBooks() {
        String listOfNFBooks = "";
        int index = 0;
        if (allBooks.isEmpty()) {
            return "There are no books stored.";
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder instanceof NonFiction) {
                    listOfNFBooks += index + ": " + placeholder.toString();
                    index++;
                }
            }
        }
        if (listOfNFBooks.isEmpty()) {
            return "There are no Non-fiction books stored.";
        } else {
            return listOfNFBooks;
        }
    }

    /**
     * Returns a string representation of all the Fiction books in the library system.
     *
     * @return String
     */
    public String showFictionBooks() {
        String listOfFictBooks = "";
        int index = 0;
        if (allBooks.isEmpty()) {
            return "There are no books stored.";
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder instanceof FictionBook) {
                    listOfFictBooks += index + ": " + placeholder.toString();
                    index++;
                }
            }
        }
        if (listOfFictBooks.isEmpty()) {
            return "There are no Fiction books stored.";
        } else {
            return listOfFictBooks;
        }
    }

    /**
     * Returns a string representation of all the Geography books in the library system.
     *
     * @return String
     */
    public String showGeographyBooks() {
        String listOfGeoBooks = "";
        int index = 0;
        if (allBooks.isEmpty()) {
            return "There are no books stored.";
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder instanceof FictionBook) {
                    listOfGeoBooks += index + ": " + placeholder.toString();
                    index++;
                }
            }
        }
        if (listOfGeoBooks.isEmpty()) {
            return "There are no Geography books stored.";
        } else {
            return listOfGeoBooks;
        }
    }

    /**
     * Returns a string representation of all the history books in the library system.
     *
     * @return String
     */
    public String showHistoryBooks() {
        String listOfHistBooks = "";
        int index = 0;
        if (allBooks.isEmpty()) {
            return "There are no books stored.";
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder instanceof History) {
                    listOfHistBooks += index + ": " + placeholder.toString();
                    index++;
                }
            }
        }
        if (listOfHistBooks.isEmpty()) {
            return "There are no History books stored.";
        } else {
            return listOfHistBooks;
        }
    }

    /**
     * Returns a string representation of all the Ebooks books in the library system.
     *
     * @return String
     */
    public String showEbooksBooks() {
        String listOfEBooks = "";
        int index = 0;
        if (allBooks.isEmpty()) {
            return "There are no books stored.";
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder instanceof Ebook) {
                    listOfEBooks += index + ": " + placeholder.toString();
                    index++;
                }
            }
        }
        if (listOfEBooks.isEmpty()) {
            return "There are no EBooks stored.";
        } else {
            return listOfEBooks;
        }
    }

    /**
     * Returns a list of books with the keyword in their titles.
     *
     * @param wordIn
     * @return String
     */
    public String searchWord(String wordIn) {
        String listOfOccurance = "";
        if (allBooks.isEmpty()) {
            return "There are no Books stored";
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder.getTitle().toLowerCase().contains(wordIn.toLowerCase())) {
                    listOfOccurance += placeholder.toString();
                }
            }
        }
        if (listOfOccurance.isEmpty()) {
            return "There are no Books with that keyword";
        } else {
            return listOfOccurance;
        }
    }

    /**
     * Retrieves a book by its ISBN.
     *
     * @param isbnIn
     * @return Book Object
     */
    public Book getBookByIsbn(String isbnIn) {
        int index = 0;
        if (allBooks.isEmpty()) {
            return null;
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder.getIsbn().equalsIgnoreCase(isbnIn)) {
                    return placeholder;
                }
            }
        }
        return null;
    }

    /**
     * Retrieves a book by its Title.
     *
     * @param titleIn
     * @return Book Object
     */
    public Book getBookByTitle(String titleIn) {
        int index = 0;
        if (allBooks.isEmpty()) {
            return null;
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder.getTitle().equalsIgnoreCase(titleIn)) {
                    return placeholder;
                }
            }
        }
        return null;
    }

    /**
     * Retrieves a book by its Author.
     *
     * @param authorIn
     * @return Book Object
     */
    public Book getBookByAuthor(String authorIn) {
        int index = 0;
        if (allBooks.isEmpty()) {
            return null;
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder.getAuthor().equalsIgnoreCase(authorIn)) {
                    return placeholder;
                }
            }
        }
        return null;
    }

    /**
     * Retrieves all books with a specific ISBN.
     *
     * @param isbnIn
     * @return String
     */
    public String getBooksByIsbn(String isbnIn) {
        String listOfOccurance = "";
        int index = 0;
        if (allBooks.isEmpty()) {
            return "There are no Books stored";
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder.getIsbn().equalsIgnoreCase(isbnIn)) {
                    listOfOccurance += index + ": " + placeholder.toString();
                    index++;
                }
            }
        }
        if (listOfOccurance.isEmpty()) {
            return "There are no Books with that ISBN";
        } else {
            return listOfOccurance;
        }
    }

    /**
     * Retrieves all books with a specific Title.
     *
     * @param titleIn
     * @return String
     */
    public String getBooksByTitle(String titleIn) {
        String listOfOccurance = "";
        int index = 0;
        if (allBooks.isEmpty()) {
            return "There are no Books stored";
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder.getTitle().equalsIgnoreCase(titleIn)) {
                    listOfOccurance += index + ": " + placeholder.toString();
                    index++;
                }
            }
        }
        if (listOfOccurance.isEmpty()) {
            return "There are no Books with that Title";
        } else {
            return listOfOccurance;
        }
    }

    /**
     * Retrieves all books with a specific Author.
     *
     * @param authorIn
     * @return String
     */
    public String getBooksByAuthor(String authorIn) {
        String listOfOccurance = "";
        int index = 0;
        if (allBooks.isEmpty()) {
            return "There are no Books stored";
        } else {
            for (Book placeholder : allBooks) {
                if (placeholder.getAuthor().equalsIgnoreCase(authorIn)) {
                    listOfOccurance += index + ": " + placeholder.toString();
                    index++;
                }
            }
        }
        if (listOfOccurance.isEmpty()) {
            return "There are no Books with that Author";
        } else {
            return listOfOccurance;
        }
    }

    /**
     * Returns a string representation of titles of all books in alphabetical order.
     *
     * @return String
     */
    public String alphabeticalOrder() {
        ArrayList<String> titles = new ArrayList<>();

        for (Book placeholder : allBooks) {
            titles.add(placeholder.getTitle());
        }

        Collections.sort(titles);

        String sortedTitles = String.join("\n", titles);
        return sortedTitles;
    }

    /**
     * Returns the edition of all books
     *
     * @return String
     */
    public String showEditionOfEachBook() {
        String returnValue = "";
        if (allBooks.size() > 0) {
            for (Book book : allBooks) {
                returnValue += "\nTitle: " + book.getTitle() + "\nEdition: " + iReading.getEdition();
            }
        } else {
            returnValue = "There are no Books in the Library System";
        }
        return returnValue;
    }

    /**
     * The save method uses the XStream component to write all the objects in the posts ArrayList
     * to the posts.xml file stored on the hard disk.
     *
     * @throws Exception An exception is thrown if an error occurred during the save e.g. drive is full.
     */
    public static void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("books.xml"));
        out.writeObject(allBooks);
        out.close();

    }

    public static void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{Book.class, NonFiction.class, FictionBook.class, Geography.class, History.class, Ebook.class};
        XStream xstream = new XStream(new DomDriver());
        //setting up the xstream object with default security and the above classes
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("books.xml"));
        allBooks = (ArrayList<Book>) in.readObject();
        in.close();
    }
}
