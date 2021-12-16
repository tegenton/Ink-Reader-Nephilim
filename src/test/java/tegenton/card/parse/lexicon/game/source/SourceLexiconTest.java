package tegenton.card.parse.lexicon.game.source;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;

public class SourceLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(SourceVerb.class)
    void verb(SourceVerb verb) {
        word = verb;
    }
}
