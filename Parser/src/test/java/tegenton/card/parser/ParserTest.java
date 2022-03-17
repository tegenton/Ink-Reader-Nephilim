package tegenton.card.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.KeywordAbilityNode;
import tegenton.card.parser.node.KeywordNode;
import tegenton.card.parser.node.PermanentNode;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
        try {
            assertEquals(expected, parser.parse());
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void keyword() {
        tokens.add(Keyword.BANDING);
        Parser parser = new Parser(tokens);
        expected = new CardNode(new PermanentNode(new KeywordAbilityNode(
                new KeywordNode(new InputItem(Keyword.BANDING)))));
        try {
            assertEquals(expected, parser.parse());
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }
    }
}
