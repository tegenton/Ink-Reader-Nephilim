package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.KeywordAction;

import java.util.Optional;

public class KeywordActionToken extends Token {
    private KeywordActionToken(KeywordAction word) {
        this.word = word;
    }

    static Optional<Token> fromString(String s) {
        KeywordAction keywordAction = KeywordAction.fromString(s).orElse(null);
        if (keywordAction != null) {
            return Optional.of(new KeywordActionToken(keywordAction));
        }
        return Optional.empty();
    }
}
