package tegenton.card.parser.node.atom.symbol;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Tap;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;

import java.util.List;

public class TapSymbolNode extends Node {
    public TapSymbolNode(final Tap t) {
        super(t);
    }

    public TapSymbolNode(final List<Word> tokens) throws ParseError {
        super(tokens);
        expect(Symbol.LBRACKET);
        consume(Tap.class);
        expect(Symbol.RBRACKET);
    }
}
