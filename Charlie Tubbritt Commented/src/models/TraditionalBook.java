package models;

import utils.Utilities;

public abstract class TraditionalBook extends Book {
    private int yearPublished;

    /**
     *
     * This is the constructor for Traditional Book
     * it pulls all attributes from Book and sets an additional
     * attribute, yearPublished.
     *
     * @param isbnIn
     * @param titleIn
     * @param authorIn
     * @param numOfPagesIn
     * @param yearPublishedIn
     */
    public TraditionalBook(String isbnIn, String titleIn, String authorIn, int numOfPagesIn, int yearPublishedIn) {
        super(isbnIn, titleIn, authorIn, numOfPagesIn);
        setYearPublished(yearPublishedIn);
    }

    /**
     * Returns the year the book was published.
     *
     * @return The year the book was published.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets the year the book was published once the year is within a valid range.
     * If the year is not within the valid range, sets the year to 0.
     *
     * @param yearPublishedIn The year the book was published.
     */
    public void setYearPublished(int yearPublishedIn){
        if(Utilities.validRange(yearPublishedIn,1300, 2023)) {
            yearPublished = yearPublishedIn;
        }else {
            yearPublished = 0;
        }
    }


    /**
     * Returns a string representation of the TraditionalBook object.
     *
     * @return String
     */
    public String toString(){
        return super.toString() + "\nyearPublished: " + yearPublished;
    }

    /**
     * Returns the book type
     *
     * @return String
     */
    @Override
    public String getBookType(){
        return "This is a Traditional Book";
    }
}