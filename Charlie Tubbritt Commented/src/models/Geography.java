package models;

import utils.ScannerInput;
import utils.iReading;

import java.util.HashMap;

public class Geography extends NonFiction implements iReading {
    int elements;
    public final HashMap<Integer, String> elementOptions = new HashMap<Integer, String>();

    /**
     * This is the constructor for Geography
     * it pulls all attributes from NonFiction and sets an additional
     * attribute, elements. It all calls the createHashmap method
     * so a hashmap is implemented for each Object
     *
     * @param isbnIn
     * @param titleIn
     * @param authorIn
     * @param numOfPagesIn
     * @param yearPublishedIn
     * @param topicIn
     * @param elementsIn
     */
    public Geography(String isbnIn, String titleIn, String authorIn, int numOfPagesIn, int yearPublishedIn, String topicIn, int elementsIn) {
        super(isbnIn, titleIn, authorIn, numOfPagesIn, yearPublishedIn, topicIn);
        setElements(elementsIn);
        createHashmap();
    }


    /**
     * Creates a hasmap and adds preset values to be used
     * in the elements attribute
     */
    private void createHashmap() {
        elementOptions.put(1, "The world in Spatial Terms");
        elementOptions.put(2, "Places and Regions");
        elementOptions.put(3, "Physical System");
        elementOptions.put(4, "Human Systems");
    }

    /**
     * Gets the element of the geography book based on the selected option.
     *
     * @return String.
     */
    public String getElement() {
        return elementOptions.get(elements);
    }

    /**
     * Sets the element of the geography book.
     *
     * @param elementIn
     */
    public void setElements(int elementIn){
        elements = elementIn;

    }

    /**
     * Returns the book type
     *
     * @return String
     */
    public String getBookType() {
        return "This is a Geography Book";
    }

    /**
     * Returns a string representation of the Geography object.
     *
     * @return String
     */
    public String toString() {
        return super.toString() + "\nElements: " + getElement();
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
