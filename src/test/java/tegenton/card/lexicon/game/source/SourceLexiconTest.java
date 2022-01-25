package tegenton.card.lexicon.game.source;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.lexicon.LexiconTest;

public class SourceLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(SourceNoun.class)
    void noun(SourceNoun noun) {
        word = noun;
    }

    @ParameterizedTest
    @EnumSource(SourceVerb.class)
    void verb(SourceVerb verb) {
        word = verb;
    }
}
