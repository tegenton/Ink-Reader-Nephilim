package tegenton.card.parser;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubordinateConjunctionNodeTest {
    @Test
    void asLongAs() {
        final List<Word> tokens =
                List.of(SubordinateConjunction.AS, Symbol.SPACE,
                        SubordinateConjunction.LONG, Symbol.SPACE,
                        SubordinateConjunction.AS);
        final SubordinateConjunctionNode node =
                new SubordinateConjunctionNode(SubordinateConjunction.AS,
                        SubordinateConjunction.LONG, SubordinateConjunction.AS);
        assertEquals(node, new SubordinateConjunctionNode(tokens));
    }

    @Test
    void asThough() {
        final List<Word> tokens =
                List.of(SubordinateConjunction.AS, Symbol.SPACE,
                        SubordinateConjunction.THOUGH);
        final SubordinateConjunctionNode node =
                new SubordinateConjunctionNode(SubordinateConjunction.AS,
                        SubordinateConjunction.THOUGH);
        assertEquals(node, new SubordinateConjunctionNode(tokens));
    }

    @Test
    void but() {
        final List<Word> tokens = List.of(SubordinateConjunction.BUT);
        final SubordinateConjunctionNode node =
                new SubordinateConjunctionNode(SubordinateConjunction.BUT);
        assertEquals(node, new SubordinateConjunctionNode(tokens));
    }

    @Test
    void except() {
        final List<Word> tokens = List.of(SubordinateConjunction.EXCEPT);
        final SubordinateConjunctionNode node =
                new SubordinateConjunctionNode(SubordinateConjunction.EXCEPT);
        assertEquals(node, new SubordinateConjunctionNode(tokens));
    }

    @Test
    void ifTest() {
        final List<Word> tokens = List.of(SubordinateConjunction.IF);
        final SubordinateConjunctionNode node =
                new SubordinateConjunctionNode(SubordinateConjunction.IF);
        assertEquals(node, new SubordinateConjunctionNode(tokens));
    }

    @Test
    void whereTest() {
        final List<Word> tokens = List.of(SubordinateConjunction.WHERE);
        final SubordinateConjunctionNode node =
                new SubordinateConjunctionNode(SubordinateConjunction.WHERE);
        assertEquals(node, new SubordinateConjunctionNode(tokens));
    }
}
