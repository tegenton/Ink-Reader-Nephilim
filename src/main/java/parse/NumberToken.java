package parse;

import parse.lexicon.Number;

import java.util.Optional;

class NumberToken extends Token {
    private NumberToken(Number word) {
        this.word = word;
    }

    static Optional<Token> fromString(String s) {
        Number number = Number.fromString(s).orElse(null);
        if (number != null) {
            return Optional.of(new NumberToken(number));
        }
        return Optional.empty();
    }
}
