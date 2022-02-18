package tegenton.card.parser.node.ability;

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
import tegenton.card.parser.node.QualityNode;
import tegenton.card.parser.node.atom.AtomicObjectNode;
import tegenton.card.parser.node.atom.ColorNode;
import tegenton.card.parser.node.phrase.headword.ObjectNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeywordNodeTest {
    public static List<Word> tokens;
    public static KeywordNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    void compare() {
        assertEquals(expected, new KeywordNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void simpleKeywords() {
        List<Keyword> keywordList =
                List.of(Keyword.BANDING, Keyword.DEFENDER, Keyword.FEAR,
                        Keyword.FLYING, Keyword.HASTE, Keyword.INDESTRUCTIBLE,
                        Keyword.REACH, Keyword.TRAMPLE, Keyword.VIGILANCE);
        for (Keyword keyword : keywordList) {
            tokens.add(keyword);
            expected = new KeywordNode(keyword);
            compare();
        }
    }

    @Test
    void firstStrike() {
        tokens.addAll(List.of(Adjective.FIRST, Symbol.SPACE, Keyword.STRIKE));
        expected = new KeywordNode(Adjective.FIRST, Keyword.STRIKE);
        compare();
    }

    @Test
    void protection() {
        tokens.addAll(
                List.of(Keyword.PROTECTION, Symbol.SPACE, Preposition.FROM,
                        Symbol.SPACE, ColorWord.WHITE));
        expected = new KeywordNode(Keyword.PROTECTION, Preposition.FROM,
                new QualityNode(new ColorNode(ColorWord.WHITE)));
        compare();
    }

    @Test
    void enchant() {
        tokens.addAll(
                List.of(Keyword.ENCHANT, Symbol.SPACE, CardType.CREATURE));
        expected = new KeywordNode(Keyword.ENCHANT,
                new ObjectNode(new AtomicObjectNode(CardType.CREATURE)));
        compare();
    }

    @Test
    void walk() {
        tokens.addAll(List.of(LandType.ISLAND, Keyword.WALK));
        expected = new KeywordNode(
                new ObjectNode(new AtomicObjectNode(LandType.ISLAND)),
                Keyword.WALK);
        compare();
    }
}
