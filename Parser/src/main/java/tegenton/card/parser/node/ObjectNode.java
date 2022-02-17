package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.atom.AtomicObjectNode;

import java.util.List;

public class ObjectNode extends Node {
    public ObjectNode(final Node... nodes) {
        super(nodes);
    }

    public ObjectNode(final List<Word> tokens) {
        super(tokens);
        addChild(new DeterminerNode(getTokens()));
        expect(Symbol.SPACE);
        addChild(new AtomicObjectNode(getTokens()));
    }
}
