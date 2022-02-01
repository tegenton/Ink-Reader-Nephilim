package tegenton.card.lexicon.game.source.target;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.lexicon.LexiconTest;

public class TargetLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(TargetAdjective.class)
    void adjective(TargetAdjective adjective) {
        word = adjective;
    }

    @ParameterizedTest
    @EnumSource(TargetNoun.class)
    void noun(TargetNoun noun) {
        word = noun;
    }

    @ParameterizedTest
    @EnumSource(TargetVerb.class)
    void verb(TargetVerb verb) {
        word = verb;
    }

    @ParameterizedTest
    @EnumSource(TargetAuxiliaryVerb.class)
    void auxiliaryVerb(TargetAuxiliaryVerb verb) {
        word = verb;
    }
}