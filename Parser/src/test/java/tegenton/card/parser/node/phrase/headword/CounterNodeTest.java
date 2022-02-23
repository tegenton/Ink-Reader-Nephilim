package tegenton.card.parser.node.phrase.headword;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.type.CounterType;
import tegenton.card.lexicon.value.DigitNumber;
import tegenton.card.parser.ParseError;
import tegenton.card.parser.node.atom.StatModNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterNodeTest {
    public static List<Word> tokens;
    public static CounterNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() throws ParseError {
        assertEquals(expected, new CounterNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void corpse() {
        tokens.addAll(
                List.of(CounterType.CORPSE, Symbol.SPACE, PlayerVerb.COUNTER));
        expected = new CounterNode(CounterType.CORPSE);
    }

    @Test
    void mire() {
        tokens.addAll(
                List.of(CounterType.MIRE, Symbol.SPACE, PlayerVerb.COUNTER));
        expected = new CounterNode(CounterType.MIRE);
    }

    @Test
    void plusOneplusOne() {
        tokens.addAll(List.of(Symbol.PLUS, new DigitNumber(1), Symbol.SLASH,
                Symbol.PLUS, new DigitNumber(1), Symbol.SPACE,
                PlayerVerb.COUNTER));
        expected = new CounterNode(
                new StatModNode(Symbol.PLUS, new DigitNumber(1), Symbol.PLUS,
                        new DigitNumber(1)));
    }

    @Test
    void vitality() {
        tokens.addAll(List.of(CounterType.VITALITY, Symbol.SPACE,
                PlayerVerb.COUNTER));
        expected = new CounterNode(CounterType.VITALITY);
    }
}
