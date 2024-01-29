package models;

import utils.Utilities;

public abstract class NonFiction extends TraditionalBook{
    String topic;


    /**
     *This is the constructor for NonFiction
     *it pulls all attributes from TraditionBook and sets an additional
     *attribute, topic.
     *
     * @param isbnIn
     * @param titleIn
     * @param authorIn
     * @param numOfPagesIn
     * @param yearPublishedIn
     * @param topicIn
     */
    public NonFiction(String isbnIn, String titleIn, String authorIn, int numOfPagesIn, int yearPublishedIn, String topicIn) {
        super(isbnIn, titleIn, authorIn, numOfPagesIn, yearPublishedIn);
        setTopic(topicIn);

    }

    /**
     * Gets the topic of the non-fiction book.
     *
     * @return String
     */
    public String getTopic(){
        return topic;
    }

    /**
     * Sets the topic of the non-fiction book, limiting it to a maximum of 30 characters.
     *
     * @param topicIn
     */
    public void setTopic(String topicIn){
        topic = Utilities.truncateString(topicIn, 30);
    }

    /**
     * Returns a string representation of the NonFiction object.
     *
     * @return String
     */
    public String toString(){
        return super.toString() + "\nTopic: " + topic;
    }

    /**
     * Returns the book type
     *
     * @return String
     */
    @Override
    public String getBookType(){
        return "This is a Non-Fiction Book";
    }
}
