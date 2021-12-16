package tegenton.card.parse.lexicon.game.source.target;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;
import tegenton.card.parse.lexicon.game.source.target.TargetNoun;
import tegenton.card.parse.lexicon.game.source.target.TargetVerb;

public class TargetLexiconTest extends LexiconTest {
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
}
