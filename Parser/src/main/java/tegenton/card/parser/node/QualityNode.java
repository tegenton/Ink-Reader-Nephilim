package tegenton.card.parser.node;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.Node;
import tegenton.card.parser.node.atom.ColorNode;

import java.util.List;

public class QualityNode extends Node {
    public QualityNode(ColorNode colorNode) {
        super(colorNode);
    }

    public QualityNode(List<Word> tokens) {
        super(tokens);
        addChild(new ColorNode(getTokens()));
    }
}
