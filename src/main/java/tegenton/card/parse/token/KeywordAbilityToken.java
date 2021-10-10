package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.KeywordAbility;

final class KeywordAbilityToken extends Token {
    private KeywordAbilityToken(final KeywordAbility word) {
        this.setWord(word);
    }

    static KeywordAbilityToken fromString(final String s) {
        final KeywordAbility keywordAbility = KeywordAbility.fromString(s);
        if (keywordAbility != null) {
            return new KeywordAbilityToken(keywordAbility);
        }
        return null;
    }
}
