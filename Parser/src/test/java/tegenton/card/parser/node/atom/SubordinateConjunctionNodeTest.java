package tegenton.card.parser.node.atom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubordinateConjunctionNodeTest {
    public static List<Word> tokens;
    public static SubordinateConjunctionNode node;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(node, new SubordinateConjunctionNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void asLongAs() {
        tokens.addAll(List.of(SubordinateConjunction.AS, Symbol.SPACE,
                SubordinateConjunction.LONG, Symbol.SPACE,
                SubordinateConjunction.AS));
        node = new SubordinateConjunctionNode(SubordinateConjunction.AS,
                SubordinateConjunction.LONG, SubordinateConjunction.AS);
    }

    @Test
    void asThough() {
        tokens.addAll(List.of(SubordinateConjunction.AS, Symbol.SPACE,
                SubordinateConjunction.THOUGH));
        node = new SubordinateConjunctionNode(SubordinateConjunction.AS,
                SubordinateConjunction.THOUGH);
    }

    @Test
    void but() {
        tokens.add(SubordinateConjunction.BUT);
        node = new SubordinateConjunctionNode(SubordinateConjunction.BUT);
    }

    @Test
    void except() {
        tokens.add(SubordinateConjunction.EXCEPT);
        node = new SubordinateConjunctionNode(SubordinateConjunction.EXCEPT);
    }

    @Test
    void ifTest() {
        tokens.add(SubordinateConjunction.IF);
        node = new SubordinateConjunctionNode(SubordinateConjunction.IF);
    }

    @Test
    void whereTest() {
        tokens.add(SubordinateConjunction.WHERE);
        node = new SubordinateConjunctionNode(SubordinateConjunction.WHERE);
    }
}
