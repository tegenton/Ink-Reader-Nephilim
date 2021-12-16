package tegenton.card.parse.lexicon.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;
import tegenton.card.parse.lexicon.Word;

public class GameLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(Keyword.class)
    void keyword(Word keyword) {
        word = keyword;
    }

    @ParameterizedTest
    @EnumSource(TriggerWord.class)
    void trigger(Word trigger) {
        word = trigger;
    }

    @ParameterizedTest
    @EnumSource(Zone.class)
    void zone(Word zone) {
        word = zone;
    }
}
