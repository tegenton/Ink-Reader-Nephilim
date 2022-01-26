package tegenton.card.parser.node;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparativeTest {
    public static List<Word> tokens;
    public static ComparativeNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        ComparativeNode actual = new ComparativeNode(tokens);
        assertEquals(expected, actual);
        assertEquals(0, tokens.size());
    }

    @Test
    void less() {
        Collections.addAll(tokens, Comparative.LESS);
        expected = new ComparativeNode(Comparative.LESS);
    }
}
