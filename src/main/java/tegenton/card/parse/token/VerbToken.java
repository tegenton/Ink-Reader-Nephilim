package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Verb;

class VerbToken extends Token {
    private VerbToken(Verb word) {
        this.word = word;
    }

    static VerbToken fromString(String s) {
        Verb verb = Verb.fromString(s);
        if (verb != null) {
            return new VerbToken(verb);
        }
        return null;
    }
}
