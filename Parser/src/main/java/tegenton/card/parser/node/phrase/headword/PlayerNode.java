package tegenton.card.parser.node.phrase.headword;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.Node;
import tegenton.card.parser.node.atom.AtomicPlayerNode;
import tegenton.card.parser.node.modifier.PremodifierNode;

import java.util.List;

public class PlayerNode extends Node {
    public PlayerNode(final Node... nodes) {
        super(nodes);
    }

    public PlayerNode(final List<Word> tokens) {
        super(tokens);
        addChild(new PremodifierNode(getTokens()));
        expect(Symbol.SPACE);
        addChild(new AtomicPlayerNode(getTokens()));
    }
}
