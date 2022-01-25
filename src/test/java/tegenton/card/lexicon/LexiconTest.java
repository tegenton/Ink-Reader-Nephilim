package tegenton.card.lexicon;

import org.junit.jupiter.api.AfterEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
