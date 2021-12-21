package tegenton.card.parse.lexicon.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.parse.LexiconTest;
import tegenton.card.parse.lexicon.Word;

public class SymbolLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(ColorWord.class)
    void colorWord(ColorWord color) {
        word = color;
    }

    @ParameterizedTest
    @EnumSource(Color.class)
    void color(Word color) {
        word = color;
    }
}
