package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.EnglishNumber;

class EnglishNumberToken extends Token {
    private EnglishNumberToken(EnglishNumber word) {
        this.word = word;
    }

    static EnglishNumberToken fromString(String s) {
        EnglishNumber englishNumber = EnglishNumber.fromString(s);
        if (englishNumber != null) {
            return new EnglishNumberToken(englishNumber);
        }
        return null;
    }
}
