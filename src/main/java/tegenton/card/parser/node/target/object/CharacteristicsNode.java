package tegenton.card.parser.node.target.object;

import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.ConjunctionNode;
import tegenton.card.parser.node.ParentNode;
import tegenton.card.parser.node.ParseNode;

import java.util.List;

public class CharacteristicsNode extends ParentNode {
    public CharacteristicsNode(ParseNode... children) {
        super(children);
    }

    public CharacteristicsNode(List<Word> tokens) {
        super(tokens);
        addChild(new CharacteristicNode(getTokens()));
        if (peek() == Symbol.SPACE && peek(1) instanceof Conjunction) {
            pop();
            setConjunction(new ConjunctionNode(getTokens()));
            expect(Symbol.SPACE);
            addChild(new CharacteristicNode(getTokens()));
        }
    }
}
