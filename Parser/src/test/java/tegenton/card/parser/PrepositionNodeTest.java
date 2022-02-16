package tegenton.card.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrepositionNodeTest {
    List<Word> tokens;
    PrepositionNode expected;

    @AfterEach
    void compare() {
        assertEquals(expected, new PrepositionNode(tokens));
    }

    @Test
    void above() {
        tokens = List.of(Preposition.ABOVE);
        expected = new PrepositionNode(Preposition.ABOVE);
    }

    @Test
    void forTest() {
        tokens = List.of(Preposition.FOR);
        expected = new PrepositionNode(Preposition.FOR);
    }

    @Test
    void from() {
        tokens = List.of(Preposition.FROM);
        expected = new PrepositionNode(Preposition.FROM);
    }

    @Test
    void in() {
        tokens = List.of(Preposition.IN);
        expected = new PrepositionNode(Preposition.IN);
    }

    @Test
    void of() {
        tokens = List.of(Preposition.OF);
        expected = new PrepositionNode(Preposition.OF);
    }

    @Test
    void on() {
        tokens = List.of(Preposition.ON);
        expected = new PrepositionNode(Preposition.ON);
    }

    @Test
    void to() {
        tokens = List.of(Preposition.TO);
        expected = new PrepositionNode(Preposition.TO);
    }

    @Test
    void under() {
        tokens = List.of(Preposition.UNDER);
        expected = new PrepositionNode(Preposition.UNDER);
    }

    @Test
    void with() {
        tokens = List.of(Preposition.WITH);
        expected = new PrepositionNode(Preposition.WITH);
    }

}
