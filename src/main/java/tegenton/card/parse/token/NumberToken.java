package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Number;

final class NumberToken extends Token {
    private NumberToken(final Number word) {
        this.setWord(word);
    }

    static NumberToken fromString(final String s) {
        final Number number = Number.fromString(s);
        if (number != null) {
            return new NumberToken(number);
        }
        return null;
    }
}
