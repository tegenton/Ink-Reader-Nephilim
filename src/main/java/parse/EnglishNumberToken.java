package parse;

import parse.lexicon.EnglishNumber;

import java.util.Optional;

class EnglishNumberToken extends Token {
    private EnglishNumberToken(EnglishNumber word) {
        this.word = word;
    }

    static Optional<Token> fromString(String s) {
        EnglishNumber englishNumber = EnglishNumber.fromString(s).orElse(null);
        if (englishNumber != null) {
            return Optional.of(new EnglishNumberToken(englishNumber));
        }
        return Optional.empty();
    }
}
