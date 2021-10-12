package tegenton.card.parse.token;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenTest {
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
            Assertions.assertEquals(expected.get(i).getWord().getWord(), tokens.get(i).getWord().getWord());
        }
    }

    @Test
    void divination() {
        tokens = Token.tokenize("Draw two cards.");
        expected.add(VerbToken.fromString("Draw"));
        expected.add(EnglishNumberToken.fromString("Two"));
        expected.add(SubjectToken.fromString("cards"));
        expected.add(PunctuationToken.fromString("."));
    }

    @Test
    void oneLineOpt() {
        tokens = Token.tokenize("Scry 1. Draw a card.");
        expected.add(KeywordActionToken.fromString("Scry"));
        expected.add(NumberToken.fromString("1"));
        expected.add(PunctuationToken.fromString("."));
        expected.add(VerbToken.fromString("Draw"));
        expected.add(ArticleToken.fromString("a"));
        expected.add(SubjectToken.fromString("card"));
        expected.add(PunctuationToken.fromString("."));
    }

    @Test
    void healersHawk() {
        tokens = Token.tokenize("Flying, Lifelink");
        expected.add(KeywordAbilityToken.fromString("Flying"));
        expected.add(PunctuationToken.fromString(","));
        expected.add(KeywordAbilityToken.fromString("Lifelink"));
    }
}
