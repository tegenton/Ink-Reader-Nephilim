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
}
