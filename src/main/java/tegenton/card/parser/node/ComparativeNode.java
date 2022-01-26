package tegenton.card.parser.node;

import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;

import java.util.List;

public class ComparativeNode extends ParseNode {
    public ComparativeNode(Comparative less) {
        super(less);
    }

    public ComparativeNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof Comparative) {
            setValue(pop());
        }
    }
}
