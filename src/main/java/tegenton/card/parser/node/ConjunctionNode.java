package tegenton.card.parser.node;

import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

public class ConjunctionNode extends ParseNode {
    public ConjunctionNode(Word value) {
        super(value);
    }

    public ConjunctionNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof Conjunction conjunction) {
            switch (conjunction) {
                case AND -> {
                    setValue(pop());
                    try {
                        peek();
                    } catch (IllegalStateException e) {
                        return;
                    }
                    if (peek() == Symbol.SLASH) {
                        setValue(pop());
                        expect(Conjunction.OR);
                    }
                }
                case OR, THEN -> setValue(pop());
            }
        }
    }
}
