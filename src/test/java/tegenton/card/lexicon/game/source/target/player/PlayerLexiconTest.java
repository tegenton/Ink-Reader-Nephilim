package tegenton.card.lexicon.game.source.target.player;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.lexicon.LexiconTest;

public class PlayerLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(PlayerAdverb.class)
    void adverb(PlayerAdverb adverb) {
        word = adverb;
    }

    @ParameterizedTest
    @EnumSource(PlayerAdjective.class)
    void adjective(PlayerAdjective adjective) {
        word = adjective;
    }

    @ParameterizedTest
    @EnumSource(PlayerAttribute.class)
    void attribute(PlayerAttribute attribute) {
        word = attribute;
    }

    @ParameterizedTest
    @EnumSource(PlayerVerb.class)
    void verb(PlayerVerb verb) {
        word = verb;
    }
}
