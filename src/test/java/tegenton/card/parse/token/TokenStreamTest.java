package tegenton.card.parse.token;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenStreamTest {

    public static TokenStream tokenStream;
    public static List<Token> expected;

    @BeforeEach
    void setup() {
        expected = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        int i = 0;
        while (tokenStream.hasNext()) {
            assertEquals(expected.get(i++).getWord().getWord(), tokenStream.getNext().getWord().getWord());
        }
        assertEquals(expected.size(), i);
    }

    @Test
    void divination() {
        tokenStream = new TokenStream("Draw two cards.");
        expected.add(VerbToken.fromString("Draw"));
        expected.add(EnglishNumberToken.fromString("Two"));
        expected.add(SubjectToken.fromString("cards"));
        expected.add(PunctuationToken.fromString("."));
    }

    @Test
    void healersHawk() {
        tokenStream = new TokenStream("Flying, Lifelink");
        expected.add(KeywordAbilityToken.fromString("Flying"));
        expected.add(PunctuationToken.fromString(","));
        expected.add(KeywordAbilityToken.fromString("Lifelink"));
    }

    @Test
    void checkNext() {
        tokenStream = new TokenStream("Draw two cards.");
        expected.add(VerbToken.fromString("Draw"));
        expected.add(EnglishNumberToken.fromString("Two"));
        expected.add(SubjectToken.fromString("cards"));
        expected.add(PunctuationToken.fromString("."));
        assertEquals(tokenStream.checkNext(), tokenStream.checkNext());
    }
}
