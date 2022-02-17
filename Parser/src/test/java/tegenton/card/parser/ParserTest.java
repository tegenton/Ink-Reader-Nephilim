package tegenton.card.parser;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.CardNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    void empty() {
        final List<Word> tokens = List.of();
        final CardNode expected = new CardNode(null);
        assertEquals(expected, Parser.parse(tokens));
    }

    @Test
    void ancestralRecall() {
        final List<Word> tokens = List.of();
        final CardNode expected = new CardNode(null);
        assertEquals(expected, Parser.parse(tokens));
    }
}
