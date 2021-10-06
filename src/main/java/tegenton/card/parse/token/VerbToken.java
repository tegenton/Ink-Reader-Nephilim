package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Verb;

import java.util.Optional;

class VerbToken extends Token {
    private VerbToken(Verb word) {
        this.word = word;
    }

    static Optional<Token> fromString(String s) {
        Verb verb = Verb.fromString(s).orElse(null);
        if (verb != null) {
            return Optional.of(new VerbToken(verb));
        }
        return Optional.empty();
    }
}
