package tegenton.card.parser.node.phrase;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Tap;
import tegenton.card.parser.Node;
import tegenton.card.parser.node.atom.symbol.ManaSymbolNode;
import tegenton.card.parser.node.atom.symbol.TapSymbolNode;

import java.util.List;

public class CostNode extends Node {
    CostNode(final Node... manaSymbols) {
        super(manaSymbols);
    }

    public CostNode(final List<Word> tokens) {
        super(tokens);
        while (nextToken() == Symbol.LBRACKET) {
            if (getTokens().get(1) instanceof Tap) {
                addChild(new TapSymbolNode(getTokens()));
            } else {
                addChild(new ManaSymbolNode(getTokens()));
            }
        }
    }
}
