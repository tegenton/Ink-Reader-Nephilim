package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class WordTest {
    public static Word word;

    @Test
    void getWord() {
        word = Verb.fromString("draw");
        assertNotNull(word);
        assertEquals("draw", word.getWord());
    }
}