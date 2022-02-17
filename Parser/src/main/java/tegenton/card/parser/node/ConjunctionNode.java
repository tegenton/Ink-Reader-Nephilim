package tegenton.card.parser.node;

import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

public class ConjunctionNode extends Node {
    ConjunctionNode(final Word... conjunctions) {
        super(conjunctions);
    }

    public ConjunctionNode(final List<Word> input) {
        super(input);
        if (nextToken(Conjunction.AND)) {
            consume(Conjunction.AND);
            if (nextToken(Symbol.SLASH)) {
                consume(Symbol.SLASH);
                consume(Conjunction.OR);
            }
        } else if (nextToken() instanceof Conjunction conjunction) {
            switch (conjunction) {
                case OR, THEN -> consume(conjunction);
            }
        }
    }
}
