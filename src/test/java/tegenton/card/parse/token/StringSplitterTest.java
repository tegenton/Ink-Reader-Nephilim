package tegenton.card.parse.token;

import org.junit.jupiter.api.Test;
import tegenton.card.generic.StringSplitter;

import static org.junit.jupiter.api.Assertions.*;

public class StringSplitterTest {
    public static StringSplitter stringSplitter;

    @Test
    void divination() {
        stringSplitter = new StringSplitter("Draw two cards.");
        assertTrue(stringSplitter.hasNext());
        assertEquals("Draw", stringSplitter.getNext());
        assertEquals("two", stringSplitter.getNext());
        assertEquals("cards", stringSplitter.getNext());
        assertEquals(".", stringSplitter.getNext());
        assertFalse(stringSplitter.hasNext());
    }

    @Test
    void healersHawk() {
        stringSplitter = new StringSplitter("Flying, lifelink");
        assertTrue(stringSplitter.hasNext());
        assertEquals("Flying", stringSplitter.getNext());
        assertEquals(",", stringSplitter.getNext());
        assertEquals("lifelink", stringSplitter.getNext());
        assertFalse(stringSplitter.hasNext());
    }

    @Test
    void oneLineOpt() {
        stringSplitter = new StringSplitter("Scry 1. Draw a card.");
        assertTrue(stringSplitter.hasNext());
        assertEquals("Scry", stringSplitter.getNext());
        assertEquals("1", stringSplitter.getNext());
        assertEquals(".", stringSplitter.getNext());
        assertEquals("Draw", stringSplitter.getNext());
        assertEquals("a", stringSplitter.getNext());
        assertEquals("card", stringSplitter.getNext());
        assertEquals(".", stringSplitter.getNext());
        assertFalse(stringSplitter.hasNext());
    }
}
