package tegenton.card.parser.node.symbol;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Tap;
import tegenton.card.parser.node.Node;

import java.util.List;

public class TapSymbolNode extends Node {
    public TapSymbolNode(final Tap t) {
        super(t);
    }

    public TapSymbolNode(final List<Word> tokens) {
        super(tokens);
        expect(Symbol.LBRACKET);
        consume(Tap.class);
        expect(Symbol.RBRACKET);
    }
}
