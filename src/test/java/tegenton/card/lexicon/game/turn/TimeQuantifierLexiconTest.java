package tegenton.card.lexicon.game.turn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.lexicon.LexiconTest;
import tegenton.card.lexicon.Word;

public class TimeQuantifierLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(Duration.class)
    void duration(Word duration) {
        word = duration;
    }

    @ParameterizedTest
    @EnumSource(Chronology.class)
    void chronology(Word chronology) {
        word = chronology;
    }
}
