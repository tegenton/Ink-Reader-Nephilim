package tegenton.card.parse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.lexicon.Comparative;
import tegenton.card.parse.lexicon.Word;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LexiconTest {
    @ParameterizedTest
    @EnumSource(Comparative.class)
    void comparatives(Word comparative) {
        List<Word> actual = Lexicon.lookup(comparative.getWord());
        assertEquals(1, actual.size());
        assertEquals(comparative, actual.get(0));
    }
}
