package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.EnglishNumber;

final class EnglishNumberToken extends Token {
    private EnglishNumberToken(final EnglishNumber word) {
        this.setWord(word);
    }

    static EnglishNumberToken fromString(final String s) {
        final EnglishNumber englishNumber = EnglishNumber.fromString(s);
        if (englishNumber != null) {
            return new EnglishNumberToken(englishNumber);
        }
        return null;
    }
}
