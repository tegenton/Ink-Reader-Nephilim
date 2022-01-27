package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

public class CardNode extends ParseNode {
    public CardNode(List<Word> tokens) {
        super(tokens);
        this.addChild(new PlayerPhraseNode(getTokens()));
        expect(Symbol.PERIOD);
    }

    public CardNode(ParseNode... children) {
        super(children);
    }
}
