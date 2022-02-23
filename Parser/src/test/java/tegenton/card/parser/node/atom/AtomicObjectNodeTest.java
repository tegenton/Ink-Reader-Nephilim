package tegenton.card.parser.node.atom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.CreatureType;
import tegenton.card.parser.ParseError;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AtomicObjectNodeTest {
    public static List<Word> tokens;
    public static AtomicObjectNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        try {
            assertEquals(expected, new AtomicObjectNode(tokens));
        } catch (ParseError e) {
            System.err.println("Message:" + e.getMessage());
            System.err.println("Remaining tokens: " + e.getTokens());
            fail();
        }
        assertEquals(0, tokens.size());
    }

    @Test
    void artifact() {
        tokens.add(CardType.ARTIFACT);
        expected = new AtomicObjectNode(new TypeNode(CardType.ARTIFACT));
    }

    @Test
    void card() {
        tokens.add(ObjectNoun.CARD);
        expected = new AtomicObjectNode(ObjectNoun.CARD);
    }

    @Test
    void copy() {
        tokens.add(ObjectNoun.COPY);
        expected = new AtomicObjectNode(ObjectNoun.COPY);
    }

    @Test
    void it() {
        tokens.add(ObjectNoun.IT);
        expected = new AtomicObjectNode(ObjectNoun.IT);
    }

    @Test
    void permanent() {
        tokens.add(ObjectNoun.PERMANENT);
        expected = new AtomicObjectNode(ObjectNoun.PERMANENT);
    }

    @Test
    void spell() {
        tokens.add(ObjectNoun.SPELL);
        expected = new AtomicObjectNode(ObjectNoun.SPELL);
    }

    @Test
    void they() {
        tokens.add(TargetNoun.THEY);
        expected = new AtomicObjectNode(TargetNoun.THEY);
    }

    @Test
    void tilde() {
        tokens.add(Symbol.TILDE);
        expected = new AtomicObjectNode(Symbol.TILDE);
    }

    @Test
    void token() {
        tokens.add(ObjectNoun.TOKEN);
        expected = new AtomicObjectNode(ObjectNoun.TOKEN);
    }

    @Test
    void zombie() {
        tokens.add(CreatureType.ZOMBIE);
        expected = new AtomicObjectNode(new TypeNode(CreatureType.ZOMBIE));
    }
}
