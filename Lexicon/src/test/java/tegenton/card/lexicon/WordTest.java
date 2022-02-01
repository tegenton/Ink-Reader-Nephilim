package tegenton.card.lexicon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordTest {
    public static Word[] words;
    public static List<String> values;

    @AfterEach
    void compare() {
        assertEquals(words.length, values.size());
        for (int i = 0; i < words.length; i++) {
            assertEquals(values.get(i), words[i].toString());
        }
    }

    @Test
    void adjectives() {
        words = Adjective.values();
        values = List.of("ADDITIONAL", "CHOSEN", "DIFFERENT", "EQUAL", "EXTRA", "FIRST", "NEW", "NEXT", "ROUNDED", "SAME");
    }

    @Test
    void adverb() {
        words = Adverb.values();
        values = List.of("BACK", "COMPLETELY", "EVENLY", "INSTEAD", "LIKEWISE", "NOT", "ONCE", "ONLY", "OVER", "STILL");
    }

    @Test
    void conjunction() {
        words = Conjunction.values();
        values = List.of("AND", "OR", "THEN", "UNLESS");
    }

    @Test
    void comparative() {
        words = Comparative.values();
        values = List.of("GREATER", "LESS", "MORE", "THAN");
    }
}
