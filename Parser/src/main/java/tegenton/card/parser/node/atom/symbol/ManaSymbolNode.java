package tegenton.card.parser.node.atom.symbol;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.value.DigitNumber;
import tegenton.card.lexicon.value.Variable;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;

import java.util.List;

public class ManaSymbolNode extends Node {
    public ManaSymbolNode(final Word w) {
        super(w);
    }

    public ManaSymbolNode(final List<Word> tokens) throws ParseError {
        super(tokens);
        expect(Symbol.LBRACKET);
        if (nextToken() instanceof ManaSymbol manaSymbol) {
            consume(manaSymbol);
        } else if (nextToken() instanceof Variable variable) {
            consume(variable);
        } else {
            consume(DigitNumber.class);
        }
        expect(Symbol.RBRACKET);
    }
}
