package tegenton.card.parse.token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NumberTokenTest {
    public static NumberToken numberToken;

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"})
    void validNumbers(String s) {
        numberToken = (NumberToken) NumberToken.fromString(s).orElse(null);
        assertNotNull(numberToken);
        Assertions.assertEquals(s, numberToken.getWord().getWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Whenever", "five", "X"})
    void invalid(String s) {
        numberToken = (NumberToken) NumberToken.fromString(s).orElse(null);
        assertNull(numberToken);
    }
}
