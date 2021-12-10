package tegenton.card.parse.lexicon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {
    public static Word[] words;
    public static List<String> values;

    @AfterEach
    void compare() {
        assertEquals(words.length, values.size());
        for (int i = 0; i < words.length; i++) {
            assertEquals(words[i].getWord(), values.get(i));
        }
    }

    @Test
    void conjunction() {
        words = Conjunction.values();
        values = List.of("AND", "OR", "THEN");
    }

    @Test
    void comparative() {
        words = Comparative.values();
        values = List.of("GREATER", "LESS", "MORE");
    }

    @Test
    void determiner() {
        words = Determiner.values();
        values = List.of("A", "AN", "THE", "TARGET", "THIS", "THESE", "THAT", "THOSE",
                "NO", "OTHER", "ANOTHER", "ALL", "EACH", "ANY");
    }

    @Test
    void preposition() {
        words = Preposition.values();
        values = List.of("ABOVE", "FOR", "FROM", "IN", "OF", "ON", "TO", "UNDER", "WITH");
    }

    @Test
    void triggerWord() {
        words = TriggerWord.values();
        values = List.of("WHEN", "WHENEVER", "AT");
    }

}