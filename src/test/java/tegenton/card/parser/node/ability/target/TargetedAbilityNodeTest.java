package tegenton.card.parser.node.ability.target;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.node.ValueNode;
import tegenton.card.parser.node.ability.target.object.ObjectNode;
import tegenton.card.parser.node.ability.target.player.PlayerNode;
import tegenton.card.parser.node.ability.target.player.PlayerVerbPhraseNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TargetedAbilityNodeTest {
    public static TargetedAbilityNode expected;
    public static List<Word> input;

    @BeforeEach
    void setup() {
        input = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, new TargetedAbilityNode(input));
        assertEquals(0, input.size());
    }

    @Test
    void ancestralRecall() {
        Collections.addAll(input, Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY, Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW, Symbol.SPACE, EnglishNumber.THREE, Symbol.SPACE, ObjectNoun.CARD, Morpheme.S);
        expected = new TargetedAbilityNode(new PlayerNode(PlayerVerb.PLAY), new PlayerVerbPhraseNode(PlayerVerb.DRAW, new ObjectNode(ObjectNoun.CARD, new ValueNode(EnglishNumber.THREE))));
    }
}
