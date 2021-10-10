package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Punctuation;

final class PunctuationToken extends Token {
    private PunctuationToken(final Punctuation word) {
        this.setWord(word);
    }

    static PunctuationToken fromString(final String s) {
        final Punctuation punctuation = Punctuation.fromString(s);
        if (punctuation != null) {
            return new PunctuationToken(punctuation);
        }
        return null;
    }
}
