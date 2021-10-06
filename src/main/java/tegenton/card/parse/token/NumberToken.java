package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Number;

class NumberToken extends Token {
    private NumberToken(Number word) {
        this.word = word;
    }

    static NumberToken fromString(String s) {
        Number number = Number.fromString(s);
        if (number != null) {
            return new NumberToken(number);
        }
        return null;
    }
}
