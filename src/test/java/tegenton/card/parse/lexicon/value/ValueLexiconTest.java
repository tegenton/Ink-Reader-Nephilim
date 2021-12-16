package tegenton.card.parse.lexicon.value;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import tegenton.card.parse.LexiconTest;
import java.util.stream.Stream;

public class ValueLexiconTest extends LexiconTest {
    private static Stream<String> number() {
        return ValueWordTest.digits.stream();
    }

    @ParameterizedTest
    @EnumSource(EnglishNumber.class)
    void englishNumber(EnglishNumber englishNumber) {
        word = englishNumber;
    }

    @ParameterizedTest
    @MethodSource
    void number(String digit) {
        word = Number.valueOf(digit);
    }
}
