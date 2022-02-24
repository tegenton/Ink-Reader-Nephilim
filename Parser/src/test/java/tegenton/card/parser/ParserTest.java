package tegenton.card.parser;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.ability.KeywordNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    void empty() {
        List<Word> tokens = List.of();
        ParseTree tree = new ParseTree();
        assertEquals(tree, Parser.parse(tokens));
    }

    @Test
    void keyword() {
        List<Word> tokens = List.of(Keyword.BANDING);
        ParseTree tree = new ParseTree(new CardNode(
                new PermanentNode(new KeywordNode(Keyword.BANDING))));
        assertEquals(tree, Parser.parse(tokens));
    }
}
