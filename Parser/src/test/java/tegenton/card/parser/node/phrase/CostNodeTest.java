package tegenton.card.parser.node.phrase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.Tap;
import tegenton.card.parser.node.atom.symbol.ManaSymbolNode;
import tegenton.card.parser.node.atom.symbol.TapSymbolNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostNodeTest {
    public static List<Word> tokens;
    public static CostNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, new CostNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void wubrg() {
        tokens.addAll(List.of(Symbol.LBRACKET, ManaSymbol.W, Symbol.RBRACKET,
                Symbol.LBRACKET, ManaSymbol.U, Symbol.RBRACKET, Symbol.LBRACKET,
                ManaSymbol.B, Symbol.RBRACKET, Symbol.LBRACKET, ManaSymbol.R,
                Symbol.RBRACKET, Symbol.LBRACKET, ManaSymbol.G,
                Symbol.RBRACKET));
        expected = new CostNode(new ManaSymbolNode(ManaSymbol.W),
                new ManaSymbolNode(ManaSymbol.U),
                new ManaSymbolNode(ManaSymbol.B),
                new ManaSymbolNode(ManaSymbol.R),
                new ManaSymbolNode(ManaSymbol.G));
    }

    @Test
    void tap() {
        tokens.addAll(List.of(Symbol.LBRACKET, Tap.T, Symbol.RBRACKET));
        expected = new CostNode(new TapSymbolNode(Tap.T));
    }
}
