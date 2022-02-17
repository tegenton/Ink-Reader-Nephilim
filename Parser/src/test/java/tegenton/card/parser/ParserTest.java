package tegenton.card.parser;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.AbilityNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    void empty() {
        final List<Word> tokens = List.of();
        final AbilityNode expected = new AbilityNode();
        assertEquals(expected, Parser.parse(tokens));
    }

    @Test
    void ancestralRecall() {
        final List<Word> tokens = List.of();
        final AbilityNode expected = new AbilityNode();
        assertEquals(expected, Parser.parse(tokens));
    }
}
