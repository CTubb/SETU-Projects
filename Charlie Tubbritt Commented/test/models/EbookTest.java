package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EbookTest {

    Ebook below;
    Ebook exact;
    Ebook above;
    Ebook zero;

    @BeforeEach
    void setUp() {
        below = new Ebook("123", "BookName","SomeAuthor", 5, true);
        exact = new Ebook("123456789-123456789-", "A very long book title abcdepo", "A very long author name abcdep", 1500, true);
        above = new Ebook("123456789-123456789-123456789-", "A very very long book title abcdepo", "A very very long author name abcdep", 1501, true);
        zero = new Ebook("", "", "", 0, false);
    }

    @AfterEach
    void tearDown() {
        below = exact = above = zero = null;
    }

    @Test
    void getIsInteractivity() {
        assertTrue(below.getIsInteractivity());
        assertTrue(exact.getIsInteractivity());
        assertTrue(above.getIsInteractivity());
        assertFalse(zero.getIsInteractivity());
    }

    @Test
    void setInteractivity() {
        below.setInteractivity(false);
        assertFalse(below.getIsInteractivity());

        exact.setInteractivity(false);
        assertFalse(exact.getIsInteractivity());

        above.setInteractivity(false);
        assertFalse(above.getIsInteractivity());

        zero.setInteractivity(true);
        assertTrue(zero.getIsInteractivity());
    }
}