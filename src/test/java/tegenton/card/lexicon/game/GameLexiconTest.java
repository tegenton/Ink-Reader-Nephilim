package tegenton.card.lexicon.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.lexicon.LexiconTest;
import tegenton.card.lexicon.Word;

public class GameLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(Keyword.class)
    void keyword(Word keyword) {
        word = keyword;
    }

    @ParameterizedTest
    @EnumSource(GameNoun.class)
    void noun(Word noun) {
        word = noun;
    }

    @ParameterizedTest
    @EnumSource(TriggerWord.class)
    void trigger(Word trigger) {
        word = trigger;
    }

    @ParameterizedTest
    @EnumSource(GameVerb.class)
    void verb(Word verb) {
        word = verb;
    }

    @ParameterizedTest
    @EnumSource(Zone.class)
    void zone(Word zone) {
        word = zone;
    }
}
