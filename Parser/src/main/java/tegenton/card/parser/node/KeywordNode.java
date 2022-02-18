package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;

import java.util.List;

public class KeywordNode extends Node {
    protected KeywordNode(List<Word> input) {
        super(input);
        consume(Keyword.ENCHANT);
        expect(Symbol.SPACE);
        addChild(new ObjectNode(getTokens()));
    }
}
