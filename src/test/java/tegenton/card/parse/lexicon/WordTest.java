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
    void article() {
        words = Article.values();
        values = List.of("a", "an");
    }
}
