package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Subject;

final class SubjectToken extends Token {
    private SubjectToken(final Subject word) {
        this.setWord(word);
    }

    static SubjectToken fromString(final String s) {
        final Subject subject = Subject.fromString(s);
        if (subject != null) {
            return new SubjectToken(subject);
        }
        return null;
    }
}
