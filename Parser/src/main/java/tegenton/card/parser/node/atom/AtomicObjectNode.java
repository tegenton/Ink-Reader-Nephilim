package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.type.TypeWord;
import tegenton.card.parser.node.Node;

import java.util.List;

public class AtomicObjectNode extends Node {
    public AtomicObjectNode(final Word... object) {
        super(object);
    }

    public AtomicObjectNode(final List<Word> tokens) {
        super(tokens);
        if (nextToken() instanceof ObjectNoun noun) {
            consume(noun);
            if (nextToken() == Morpheme.S) {
                consume(Morpheme.S);
            }
        } else if (nextToken() instanceof TypeWord type) {
            consume(type);
            if (nextToken() == Morpheme.S) {
                consume(Morpheme.S);
            }
        } else {
            consume(Symbol.TILDE, TargetNoun.THEY);
        }
    }
}
