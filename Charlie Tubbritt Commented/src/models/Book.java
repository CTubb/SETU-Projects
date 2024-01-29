package models;

import jdk.jshell.execution.Util;
import utils.Utilities;

public abstract class Book{

    private String title;
    private String author;
    private String isbn;
    private int numOfPages;
    private boolean isAvailable = true;

    /**
     * This is the constructor for Book
     *
     * @param isbnIn
     * @param titleIn
     * @param authorIn
     * @param numOfPagesIn
     */
    public Book(String isbnIn, String titleIn, String authorIn, int numOfPagesIn){

        isbn = Utilities.truncateString(isbnIn, 20);
        title = Utilities.truncateString(titleIn, 30);
        author = Utilities.truncateString(authorIn, 30);
        if(Utilities.validRange(numOfPagesIn, 10, 1500)){
            numOfPages = numOfPagesIn;
        }else{
            numOfPages = 0;
        }


    }

    /**
     * Gets the title of the book.
     *
     * @return String
     */
    public String getTitle(){
        return title;
    }

    /**
     * Gets the author of the book.
     *
     * @return String
     */
    public String getAuthor(){
        return author;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return String
     */
    public String getIsbn(){
        return isbn;
    }

    /**
     * Gets the number of pages in the book.
     *
     * @return the number of pages in the book.
     */
    public int getNumOfPages(){
        return numOfPages;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return String
     */
    public String toString(){
        return "\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\nNumber of Pages: " + numOfPages;
    }

    /**
     * Returns the book type
     *
     * @return String
     */
    public abstract String getBookType();
}
