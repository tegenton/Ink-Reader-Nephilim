package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Subject;

public class SubjectToken extends Token {
    private SubjectToken(Subject word) {
        this.word = word;
    }

    static SubjectToken fromString(String s) {
        Subject subject = Subject.fromString(s);
        if (subject != null) {
            return new SubjectToken(subject);
        }
        return null;
    }
}
