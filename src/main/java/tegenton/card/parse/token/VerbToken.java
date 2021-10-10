package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Verb;

final class VerbToken extends Token {
    private VerbToken(final Verb word) {
        this.setWord(word);
    }

    static VerbToken fromString(final String s) {
        final Verb verb = Verb.fromString(s);
        if (verb != null) {
            return new VerbToken(verb);
        }
        return null;
    }
}
