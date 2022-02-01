package tegenton.card.lexicon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    public static Word[] words;
    public static List<String> values;

    @AfterEach
    void compare() {
        assertEquals(words.length, values.size());
        for (int i = 0; i < words.length; i++) {
            assertEquals(values.get(i), words[i].getWord());
        }
    }

    @Test
    void adjectives() {
        words = Adjective.values();
        values = List.of("ADDITIONAL", "CHOSEN", "DIFFERENT", "EQUAL", "EXTRA", "FIRST", "NEW", "NEXT", "ROUNDED", "SAME");
    }
}
