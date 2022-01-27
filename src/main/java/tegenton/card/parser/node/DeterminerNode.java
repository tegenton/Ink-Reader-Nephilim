package tegenton.card.parser.node;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;

import java.util.List;

public class DeterminerNode extends ParseNode {
    public DeterminerNode(Determiner target) {
        super(target);
    }

    public DeterminerNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof Determiner) {
            setValue(pop());
        }
    }
}
