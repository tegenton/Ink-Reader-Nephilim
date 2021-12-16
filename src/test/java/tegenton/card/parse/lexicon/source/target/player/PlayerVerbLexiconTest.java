package tegenton.card.parse.lexicon.source.target.player;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;

public class PlayerVerbLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(PlayerVerb.class)
    void playerVerb(PlayerVerb verb) {
        word = verb;
    }
}