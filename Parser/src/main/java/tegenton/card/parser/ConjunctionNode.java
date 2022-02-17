package tegenton.card.parser;

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
        } else if (tokens.get(0) instanceof Conjunction conjunction) {
            switch (conjunction) {
                case OR, THEN -> consume(conjunction);
            }
        }
    }

    private boolean nextToken(final Word word) {
        return tokens.size() > 0 && tokens.get(0) == word;
    }
}
