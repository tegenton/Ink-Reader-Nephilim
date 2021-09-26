package parse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenizeTest {
    public static List<Token> tokens;
    public static List<Token> expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
        expected = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected.size(), tokens.size());
        for (int i = 0; i < tokens.size(); i++) {
            assertEquals(expected.get(i).getWord(), tokens.get(i).getWord());
        }
    }

    @Test
    void divination() {
        tokens = Token.tokenize("Draw two cards.");
        expected.add(VerbToken.fromString("Draw").orElse(null));
        expected.add(EnglishNumberToken.fromString("Two").orElse(null));
        expected.add(SubjectToken.fromString("cards").orElse(null));
        expected.add(PunctuationToken.fromString(".").orElse(null));
    }
}
