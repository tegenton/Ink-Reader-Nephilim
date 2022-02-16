package tegenton.card.parser;

import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

public class SubordinateConjunctionNode extends Node {

    SubordinateConjunctionNode(
            final SubordinateConjunction... subordinateConjunctions) {
        super(subordinateConjunctions);
    }

    public SubordinateConjunctionNode(final List<Word> input) {
        super(input);
        if (tokens.get(0) == SubordinateConjunction.AS) {
            consume(SubordinateConjunction.AS);
            pop(Symbol.SPACE);
            if (tokens.get(0) == SubordinateConjunction.LONG) {
                consume(SubordinateConjunction.LONG);
                pop(Symbol.SPACE);
                consume(SubordinateConjunction.AS);
            } else {
                consume(SubordinateConjunction.THOUGH);
            }
        } else {
            if (tokens.get(
                    0) instanceof SubordinateConjunction subordinateConjunction) {
                switch (subordinateConjunction) {
                    case BUT, WHERE, THOUGH, LONG, IF, EXCEPT -> consume(
                            subordinateConjunction);
                }
            }
        }
    }

}
