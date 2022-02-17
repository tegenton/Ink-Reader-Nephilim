package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.Node;

import java.util.List;

public class SubordinateConjunctionNode extends Node {

    SubordinateConjunctionNode(
            final SubordinateConjunction... subordinateConjunctions) {
        super(subordinateConjunctions);
    }

    public SubordinateConjunctionNode(final List<Word> input) {
        super(input);
        if (nextToken(SubordinateConjunction.AS)) {
            consume(SubordinateConjunction.AS);
            expect(Symbol.SPACE);
            if (nextToken(SubordinateConjunction.LONG)) {
                consume(SubordinateConjunction.LONG);
                expect(Symbol.SPACE);
                consume(SubordinateConjunction.AS);
            } else {
                consume(SubordinateConjunction.THOUGH);
            }
        } else {
            if (nextToken() instanceof SubordinateConjunction subordinateConjunction) {
                switch (subordinateConjunction) {
                    case BUT, WHERE, THOUGH, LONG, IF, EXCEPT -> consume(
                            subordinateConjunction);
                }
            }
        }
    }

}
