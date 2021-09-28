package tegenton.card.parse;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.Punctuation;

import static org.junit.jupiter.api.Assertions.*;

public class PunctuationTokenTest {
    public static PunctuationToken punctuationToken;

    @Test
    void comma() {
        punctuationToken = (PunctuationToken) PunctuationToken.fromString(",").orElse(null);
        assertNotNull(punctuationToken);
        assertEquals(Punctuation.comma, punctuationToken.getWord());
    }

    @Test
    void period() {
        punctuationToken = (PunctuationToken) PunctuationToken.fromString(".").orElse(null);
        assertNotNull(punctuationToken);
        assertEquals(Punctuation.period, punctuationToken.getWord());
    }

    @Test
    void invalid() {
        punctuationToken = (PunctuationToken) PunctuationToken.fromString("when").orElse(null);
        assertNull(punctuationToken);
    }
}
