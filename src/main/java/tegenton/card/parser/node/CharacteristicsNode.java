package tegenton.card.parser.node;

import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

public class CharacteristicsNode extends ParseNode {
    public CharacteristicsNode(ParseNode... children) {
        super(children);
    }

    public CharacteristicsNode(List<Word> tokens) {
        super(tokens);
        addChild(new CharacteristicNode(getTokens()));
        if (peek() == Symbol.SPACE && peek(1) instanceof Conjunction) {
            pop();
            addChild(new ConjunctionNode(getTokens()));
            pop();
            addChild(new CharacteristicNode(getTokens()));
        }
    }
}
