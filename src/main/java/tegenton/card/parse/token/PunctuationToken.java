package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Punctuation;

class PunctuationToken extends Token {
    private PunctuationToken(Punctuation word) {
        this.word = word;
    }

    static PunctuationToken fromString(String s) {
        Punctuation punctuation = Punctuation.fromString(s);
        if (punctuation != null) {
            return new PunctuationToken(punctuation);
        }
        return null;
    }
}
