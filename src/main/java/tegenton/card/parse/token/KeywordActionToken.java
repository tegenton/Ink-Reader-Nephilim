package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.KeywordAction;

public final class KeywordActionToken extends Token {
    private KeywordActionToken(final KeywordAction word) {
        this.setWord(word);
    }

    static KeywordActionToken fromString(final String s) {
        final KeywordAction keywordAction = KeywordAction.fromString(s);
        if (keywordAction != null) {
            return new KeywordActionToken(keywordAction);
        }
        return null;
    }
}
