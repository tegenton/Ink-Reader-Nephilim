package tegenton.card.parse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.Word;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class LexiconTest {
    public static Word word;

    @AfterEach
    void compare() {
        if (word == null) {
            return;
        }
        List<Word> actual = Lexicon.lookup(word.getWord());
        assertEquals(1, actual.size());
        assertEquals(word, actual.get(0));
    }

    @Test
    void caseInsensitive() {
        word = null;
        assertIterableEquals(Lexicon.lookup("PLAYER"), Lexicon.lookup("player"));
    }
}
