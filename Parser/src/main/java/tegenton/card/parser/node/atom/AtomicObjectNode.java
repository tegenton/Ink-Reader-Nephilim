package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.parser.node.Node;

import java.util.List;

public class AtomicObjectNode extends Node {
    public AtomicObjectNode(final Word... object) {
        super(object);
    }

    public AtomicObjectNode(final List<Word> tokens) {
        super(tokens);
        consume(ObjectNoun.CARD);
        consume(Morpheme.S);
    }
}
