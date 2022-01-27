package tegenton.card.parser.node.target.object;

import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.value.ValueWord;
import tegenton.card.parser.node.ParseNode;
import tegenton.card.parser.node.ValueNode;

import java.util.List;

public class ObjectNode extends ParseNode {
    public ObjectNode(ObjectNoun card, ValueNode... valueNode) {
        super(valueNode);
        setValue(card);
    }

    public ObjectNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof ValueWord) {
            addChild(new ValueNode(tokens));
            expect(Symbol.SPACE);
        }
        if (peek() instanceof ObjectNoun) {
            setValue(pop());
            if (peek() == Morpheme.S) {
                pop();
            }
        }
    }
}
