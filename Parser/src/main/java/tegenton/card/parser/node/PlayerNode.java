package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.atom.AtomicPlayerNode;

import java.util.List;

public class PlayerNode extends Node {
    public PlayerNode(final Node... nodes) {
        super(nodes);
    }

    public PlayerNode(final List<Word> tokens) {
        super(tokens);
        addChild(new DeterminerNode(getTokens()));
        expect(Symbol.SPACE);
        addChild(new AtomicPlayerNode(getTokens()));
    }
}
