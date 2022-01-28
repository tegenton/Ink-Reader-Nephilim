package tegenton.card.parser.node.ability;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.LandType;
import tegenton.card.parser.node.ability.target.object.ColorNode;
import tegenton.card.parser.node.type.TypeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeywordNodeTest {
    public static List<Word> tokens;
    public static KeywordNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        KeywordNode actual = new KeywordNode(tokens);
        assertEquals(expected, actual);
        assertEquals(0, tokens.size());
    }

    @Test
    void banding() {
        Collections.addAll(tokens, Keyword.BANDING);
        expected = new KeywordNode(Keyword.BANDING);
    }

    @Test
    void defender() {
        Collections.addAll(tokens, Keyword.DEFENDER);
        expected = new KeywordNode(Keyword.DEFENDER);
    }

    @Test
    void fear() {
        Collections.addAll(tokens, Keyword.FEAR);
        expected = new KeywordNode(Keyword.FEAR);
    }

    @Test
    void flying() {
        Collections.addAll(tokens, Keyword.FLYING);
        expected = new KeywordNode(Keyword.FLYING);
    }

    @Test
    void haste() {
        Collections.addAll(tokens, Keyword.HASTE);
        expected = new KeywordNode(Keyword.HASTE);
    }

    @Test
    void indestructible() {
        Collections.addAll(tokens, Keyword.INDESTRUCTIBLE);
        expected = new KeywordNode(Keyword.INDESTRUCTIBLE);
    }

    @Test
    void reach() {
        Collections.addAll(tokens, Keyword.REACH);
        expected = new KeywordNode(Keyword.REACH);
    }

    @Test
    void trample() {
        Collections.addAll(tokens, Keyword.TRAMPLE);
        expected = new KeywordNode(Keyword.TRAMPLE);
    }

    @Test
    void vigilance() {
        Collections.addAll(tokens, Keyword.VIGILANCE);
        expected = new KeywordNode(Keyword.VIGILANCE);
    }

    @Test
    void firstStrike() {
        Collections.addAll(tokens, Adjective.FIRST, Symbol.SPACE, Keyword.STRIKE);
        expected = new KeywordNode(Adjective.FIRST);
    }

    @Test
    void protection() {
        Collections.addAll(tokens, Keyword.PROTECTION, Symbol.SPACE, Preposition.FROM, Symbol.SPACE, ColorWord.BLACK);
        expected = new KeywordNode(Keyword.PROTECTION, new ColorNode(ColorWord.BLACK));
    }

    @Test
    void enchant() {
        Collections.addAll(tokens, Keyword.ENCHANT, Symbol.SPACE, CardType.CREATURE);
        expected = new KeywordNode(Keyword.ENCHANT, new TypeNode(CardType.CREATURE));
    }

    @Test
    void landwalk() {
        Collections.addAll(tokens, LandType.ISLAND, Keyword.WALK);
        expected = new KeywordNode(Keyword.WALK, new TypeNode(LandType.ISLAND));
    }
}
