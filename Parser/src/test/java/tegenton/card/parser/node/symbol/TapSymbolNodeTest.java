package tegenton.card.parser.node.symbol;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Tap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TapSymbolNodeTest {

    public static List<Word> tokens;
    public static TapSymbolNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, new TapSymbolNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void tap() {
        tokens.addAll(List.of(Symbol.LBRACKET, Tap.T, Symbol.RBRACKET));
        expected = new TapSymbolNode(Tap.T);
    }
}
