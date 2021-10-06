package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Subject;

import java.util.Optional;

public class SubjectToken extends Token {
    private SubjectToken(Subject word) {
        this.word = word;
    }

    static Optional<Token> fromString(String s) {
        Subject subject = Subject.fromString(s).orElse(null);
        if (subject != null) {
            return Optional.of(new SubjectToken(subject));
        }
        return Optional.empty();
    }
}
