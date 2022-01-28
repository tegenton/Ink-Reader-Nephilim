package tegenton.card.parser.node.ability;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.ConjunctionNode;
import tegenton.card.parser.node.DeterminerNode;
import tegenton.card.parser.node.ValueNode;
import tegenton.card.parser.node.ability.target.object.ObjectNode;
import tegenton.card.parser.node.ability.target.player.PlayerNode;
import tegenton.card.parser.node.ability.target.player.PlayerVerbPhraseNode;
import tegenton.card.parser.node.ability.target.player.ZoneNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tegenton.card.lexicon.Conjunction.THEN;
import static tegenton.card.lexicon.Determiner.ALL;
import static tegenton.card.lexicon.Determiner.EACH;
import static tegenton.card.lexicon.Morpheme.ER;
import static tegenton.card.lexicon.Morpheme.S;
import static tegenton.card.lexicon.Symbol.COMMA;
import static tegenton.card.lexicon.Symbol.SPACE;
import static tegenton.card.lexicon.game.Zone.HAND;
import static tegenton.card.lexicon.game.source.target.TargetModifier.POSSESSIVE;
import static tegenton.card.lexicon.game.source.target.TargetNoun.THEY;
import static tegenton.card.lexicon.game.source.target.object.ObjectNoun.CARD;
import static tegenton.card.lexicon.game.source.target.player.PlayerVerb.*;
import static tegenton.card.lexicon.game.type.CardType.LAND;
import static tegenton.card.lexicon.value.EnglishNumber.SEVEN;

class OneShotAbilityNodeTest {
    public static OneShotAbilityNode expected;
    public static List<Word> input;

    @BeforeEach
    void setup() {
        input = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        OneShotAbilityNode actual = new OneShotAbilityNode(input);
        assertEquals(expected, actual);
        assertEquals(0, input.size());
    }

    @Test
    void armageddon() {
        Collections.addAll(input, DESTROY, SPACE, ALL, SPACE, LAND, S);
        expected = new OneShotAbilityNode(new PlayerVerbPhraseNode(DESTROY, new ObjectNode(LAND, new DeterminerNode(ALL))));
    }

    @Test
    void wheelOfFortune() {
        Collections.addAll(input, EACH, SPACE, PLAY, ER, SPACE, DISCARD, SPACE, THEY, POSSESSIVE, SPACE, HAND, COMMA, SPACE, THEN, SPACE, DRAW, SPACE, SEVEN, SPACE, CARD, S);
        expected = new OneShotAbilityNode(new SubjectNode(EACH, new PlayerNode(PLAY)), new VerbPhraseNode(new ConjunctionNode(THEN), new PlayerVerbPhraseNode(DISCARD, new ZoneNode(HAND)), new PlayerVerbPhraseNode(DRAW, new ObjectNode(CARD, new ValueNode(SEVEN)))));
    }
}
