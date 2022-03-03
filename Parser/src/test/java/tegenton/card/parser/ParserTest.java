package tegenton.card.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.KeywordNode;
import tegenton.card.parser.node.PermanentNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    public static List<Word> tokens;
    public static CardNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @Test
    void vanillaCreature() {
        Parser parser = new Parser(tokens);
        expected = new CardNode(new PermanentNode());
        assertEquals(expected, parser.parse());
    }

    @Test
    void keyword() {
        tokens.add(Keyword.BANDING);
        Parser parser = new Parser(tokens);
        expected = new CardNode(
                new PermanentNode(new KeywordNode(Keyword.BANDING)));
        assertEquals(expected, parser.parse());
    }
}
