package tegenton.card.parse;

import tegenton.card.parse.lexicon.Punctuation;

import java.util.Optional;

class PunctuationToken extends Token {
    private PunctuationToken(Punctuation word) {
        this.word = word;
    }

    static Optional<Token> fromString(String s) {
        Punctuation punctuation = Punctuation.fromString(s).orElse(null);
        if (punctuation != null) {
            return Optional.of(new PunctuationToken(punctuation));
        }
        return Optional.empty();
    }
}