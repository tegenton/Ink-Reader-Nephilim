package tegenton.card.parser.node.atom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrepositionNodeTest {
    public static List<Word> tokens;
    public static PrepositionNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, new PrepositionNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void above() {
        tokens.add(Preposition.ABOVE);
        expected = new PrepositionNode(Preposition.ABOVE);
    }

    @Test
    void forTest() {
        tokens.add(Preposition.FOR);
        expected = new PrepositionNode(Preposition.FOR);
    }

    @Test
    void from() {
        tokens.add(Preposition.FROM);
        expected = new PrepositionNode(Preposition.FROM);
    }

    @Test
    void in() {
        tokens.add(Preposition.IN);
        expected = new PrepositionNode(Preposition.IN);
    }

    @Test
    void of() {
        tokens.add(Preposition.OF);
        expected = new PrepositionNode(Preposition.OF);
    }

    @Test
    void on() {
        tokens.add(Preposition.ON);
        expected = new PrepositionNode(Preposition.ON);
    }

    @Test
    void to() {
        tokens.add(Preposition.TO);
        expected = new PrepositionNode(Preposition.TO);
    }

    @Test
    void under() {
        tokens.add(Preposition.UNDER);
        expected = new PrepositionNode(Preposition.UNDER);
    }

    @Test
    void with() {
        tokens.add(Preposition.WITH);
        expected = new PrepositionNode(Preposition.WITH);
    }

}
