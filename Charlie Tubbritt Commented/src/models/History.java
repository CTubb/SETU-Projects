package models;

import jdk.jshell.execution.Util;
import utils.Utilities;
import utils.iReading;

public class History extends NonFiction implements iReading {

    String era;

    /**
     * This is the constructor for history
     * it pulls all attributes from NonFiction and sets an additional
     * attribute, era.
     *
     * @param isbnIn
     * @param titleIn
     * @param authorIn
     * @param numOfPagesIn
     * @param yearPublishedIn
     * @param topicIn
     * @param eraIn
     */
    public History(String isbnIn, String titleIn, String authorIn, int numOfPagesIn, int yearPublishedIn, String topicIn, String eraIn) {
        super(isbnIn, titleIn, authorIn, numOfPagesIn, yearPublishedIn, topicIn);
        setEra(eraIn);
    }

    /**
     * Gets the era of the history book.
     *
     * @return String
     */
    public String getEra() {
        return era;
    }

    /**
     * Sets the era of the history book, truncating it to a maximum of 25 characters.
     *
     * @param eraIn the era to be set for the history book.
     */
    public void setEra(String eraIn) {
        era = Utilities.truncateString(eraIn, 25);
    }


    /**
     * Returns the book type
     *
     * @return String
     */
    @Override
    public String getBookType() {
        return "This is a History Book";
    }

    /**
     * Returns a string representation of the History object.
     *
     * @return String
     */
    public String toString() {
        return super.toString() + "\nEra: " + era;
    }

    /**
     * Returns the edition of the book
     *
     * @return String
     */
    public String getEdition() {
        return "This is the latest edition of this book";
    }
}
