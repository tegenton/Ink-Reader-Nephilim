package tegenton.card.parser.node.symbol;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.value.DigitNumber;
import tegenton.card.lexicon.value.Variable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManaSymbolNodeTest {
    public static List<Word> tokens;
    public static ManaSymbolNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, new ManaSymbolNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void w() {
        tokens.addAll(List.of(Symbol.LBRACKET, ManaSymbol.W, Symbol.RBRACKET));
        expected = new ManaSymbolNode(ManaSymbol.W);
    }

    @Test
    void u() {
        tokens.addAll(List.of(Symbol.LBRACKET, ManaSymbol.U, Symbol.RBRACKET));
        expected = new ManaSymbolNode(ManaSymbol.U);
    }

    @Test
    void b() {
        tokens.addAll(List.of(Symbol.LBRACKET, ManaSymbol.B, Symbol.RBRACKET));
        expected = new ManaSymbolNode(ManaSymbol.B);
    }

    @Test
    void r() {
        tokens.addAll(List.of(Symbol.LBRACKET, ManaSymbol.R, Symbol.RBRACKET));
        expected = new ManaSymbolNode(ManaSymbol.R);
    }

    @Test
    void g() {
        tokens.addAll(List.of(Symbol.LBRACKET, ManaSymbol.G, Symbol.RBRACKET));
        expected = new ManaSymbolNode(ManaSymbol.G);
    }

    @Test
    void c() {
        tokens.addAll(List.of(Symbol.LBRACKET, ManaSymbol.C, Symbol.RBRACKET));
        expected = new ManaSymbolNode(ManaSymbol.C);
    }

    @Test
    void x() {
        tokens.addAll(List.of(Symbol.LBRACKET, Variable.X, Symbol.RBRACKET));
        expected = new ManaSymbolNode(Variable.X);
    }

    @Test
    void one() {
        tokens.addAll(
                List.of(Symbol.LBRACKET, new DigitNumber(1), Symbol.RBRACKET));
        expected = new ManaSymbolNode(new DigitNumber(1));
    }
}
