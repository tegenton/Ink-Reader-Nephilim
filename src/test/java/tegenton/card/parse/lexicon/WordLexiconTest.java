package tegenton.card.parse.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;

public class WordLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(Adjective.class)
    void adjective(Word adjective) {
        word = adjective;
    }
}
