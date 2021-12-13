package tegenton.card.parse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.lexicon.Comparative;
import tegenton.card.parse.lexicon.Conjunction;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LexiconTest {
    public static Word word;

    @AfterEach
    void compare() {
        List<Word> actual = Lexicon.lookup(word.getWord());
        assertEquals(1, actual.size());
        assertEquals(word, actual.get(0));
    }

    @ParameterizedTest
    @EnumSource(Comparative.class)
    void comparatives(Word comparative) {
        word = comparative;
    }

    @ParameterizedTest
    @EnumSource(Conjunction.class)
    void conjunction(Word conjunction) {
        word = conjunction;
    }

    @ParameterizedTest
    @EnumSource(Determiner.class)
    void determiner(Word determiner) {
        word = determiner;
    }
}
