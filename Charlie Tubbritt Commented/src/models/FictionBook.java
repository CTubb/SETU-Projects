package models;
import jdk.jshell.execution.Util;
import utils.Utilities;
import utils.iReading;

public class FictionBook extends TraditionalBook implements iReading{

    String genre;

    /**
     * This is the constructor for FictionBook
     * it pulls all attributes from TraditionalBook and sets
     * an additional attribute, genre.
     *
     * @param isbnIn
     * @param titleIn
     * @param authorIn
     * @param numOfPagesIn
     * @param yearPublishedIn
     * @param genreIn
     */
    public FictionBook(String isbnIn, String titleIn, String authorIn, int numOfPagesIn, int yearPublishedIn, String genreIn) {
        super(isbnIn, titleIn, authorIn, numOfPagesIn, yearPublishedIn);
        setGenre(genreIn);
    }

    /**
     * Gets the genre of the fiction book.
     *
     * @return String
     */
    public String getGenre(){
        return genre;
    }

    /**
     * Sets the genre of the fiction book, limiting it to a maximum of 20 characters.
     *
     * @param genreIn
     */
    public void setGenre(String genreIn){
        genre = Utilities.truncateString(genreIn, 20);
    }

    /**
     * Returns the book type
     *
     * @return String
     */
    @Override
    public String getBookType(){
        return "This is a Fiction Book";
    }

    /**
     * Returns a string representation of the Geography object.
     *
     * @return String
     */
    public String toString(){
        return super.toString() + "\nGenre: " + genre;
    }

    /**
     * Returns the edition of the book
     *
     * @return String
     */
    public String getEdition(){
        return "This is the latest edition of this book";
    }
}
