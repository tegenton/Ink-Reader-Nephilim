package tegenton.card.parse.token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tegenton.card.parse.token.lexicon.Punctuation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PunctuationTokenTest {
    public static PunctuationToken punctuationToken;

    @Test
    void comma() {
        punctuationToken = (PunctuationToken) PunctuationToken.fromString(",").orElse(null);
        assertNotNull(punctuationToken);
        Assertions.assertEquals(Punctuation.comma, punctuationToken.getWord());
    }

    @Test
    void period() {
        punctuationToken = (PunctuationToken) PunctuationToken.fromString(".").orElse(null);
        assertNotNull(punctuationToken);
        Assertions.assertEquals(Punctuation.period, punctuationToken.getWord());
    }

    @Test
    void invalid() {
        punctuationToken = (PunctuationToken) PunctuationToken.fromString("when").orElse(null);
        assertNull(punctuationToken);
    }
}
