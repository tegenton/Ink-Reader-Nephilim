package tegenton.card.parse.lexicon.source.something;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;

public class SomethingWordTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(SomethingNoun.class)
    void noun(SomethingNoun noun) {
        word = noun;
    }

    @ParameterizedTest
    @EnumSource(SomethingVerb.class)
    void verb(SomethingVerb verb) {
        word = verb;
    }
}
