package models;
import utils.iReading;

public class Ebook extends Book implements iReading {

    private boolean interactivity;

    /**
     * This is the constructor for Ebook
     * it pulls all attributes from Book and sets
     * an additional attribute, interactivity.
     * @param isbnIn
     * @param titleIn
     * @param authorIn
     * @param numOfPagesIn
     * @param interactivityIn
     */
    public Ebook(String isbnIn, String titleIn, String authorIn, int numOfPagesIn, boolean interactivityIn) {
        super(isbnIn, titleIn, authorIn, numOfPagesIn);
        setInteractivity(interactivityIn);
    }

    /**
     * Returns whether the book is interactive or not.
     *
     * @return Boolean
     */
    public Boolean getIsInteractivity(){
        return interactivity;
    }

    /**
     * Sets whether the book is interactive or not.
     *
     * @param interactivityIn
     */
    public void setInteractivity(boolean interactivityIn) {
        interactivity = interactivityIn;
    }

    /**
     * Returns the book type
     *
     * @return String
     */
    @Override
    public String getBookType(){
        return "This is an EBook";
    }

    /**
     * Returns a string representation of the EBook object.
     *
     * @return String
     */
    public String toString(){
        return super.toString() + "\nInteractivity: " + interactivity;
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
