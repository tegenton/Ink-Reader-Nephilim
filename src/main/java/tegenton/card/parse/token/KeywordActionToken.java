package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.KeywordAction;

public class KeywordActionToken extends Token {
    private KeywordActionToken(KeywordAction word) {
        this.word = word;
    }

    static KeywordActionToken fromString(String s) {
        KeywordAction keywordAction = KeywordAction.fromString(s);
        if (keywordAction != null) {
            return new KeywordActionToken(keywordAction);
        }
        return null;
    }
}
