package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.KeywordAbility;

class KeywordAbilityToken extends Token {
    private KeywordAbilityToken(KeywordAbility word) {
        this.word = word;
    }

    static KeywordAbilityToken fromString(String s) {
        KeywordAbility keywordAbility = KeywordAbility.fromString(s);
        if (keywordAbility != null) {
            return new KeywordAbilityToken(keywordAbility);
        }
        return null;
    }
}
