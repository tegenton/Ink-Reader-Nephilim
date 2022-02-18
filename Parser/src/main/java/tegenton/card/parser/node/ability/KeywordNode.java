package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.Node;
import tegenton.card.parser.node.phrase.headword.ObjectNode;

import java.util.List;

public class KeywordNode extends Node {
    public KeywordNode(List<Word> input) {
        super(input);
        consume(Keyword.ENCHANT);
        expect(Symbol.SPACE);
        addChild(new ObjectNode(getTokens()));
    }
}
