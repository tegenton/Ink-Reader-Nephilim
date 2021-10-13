package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Qualifier;

public class QualifierToken extends Token {
    private QualifierToken(final Qualifier word) {
        this.setWord(word);
    }

    static QualifierToken fromString(final String s) {
        final Qualifier qualifier = Qualifier.fromString(s);
        if (qualifier != null) {
            return new QualifierToken(qualifier);
        }
        return null;
    }
}
