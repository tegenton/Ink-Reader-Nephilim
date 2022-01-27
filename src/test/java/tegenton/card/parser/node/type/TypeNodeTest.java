package tegenton.card.parser.node.type;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.CreatureType;
import tegenton.card.lexicon.game.type.SuperType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeNodeTest {
    public static List<Word> tokens;
    public static TypeNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        TypeNode actual = new TypeNode(tokens);
        assertEquals(expected, actual);
        assertEquals(0, tokens.size());
    }

    @Test
    void basic() {
        Collections.addAll(tokens, SuperType.BASIC);
        expected = new TypeNode(SuperType.BASIC);
    }

    @Test
    void creature() {
        Collections.addAll(tokens, CardType.CREATURE);
        expected = new TypeNode(CardType.CREATURE);
    }

    @Test
    void wall() {
        Collections.addAll(tokens, CreatureType.WALL);
        expected = new TypeNode(CreatureType.WALL);
    }
}
