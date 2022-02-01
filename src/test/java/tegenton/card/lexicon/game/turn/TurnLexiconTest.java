package tegenton.card.lexicon.game.turn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.lexicon.LexiconTest;
import tegenton.card.lexicon.Word;

public class TurnLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(Phase.class)
    void phase(Word phase) {
        word = phase;
    }

    @ParameterizedTest
    @EnumSource(Step.class)
    void step(Word step) {
        word = step;
    }
}