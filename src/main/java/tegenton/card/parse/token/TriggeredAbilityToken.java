package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.TriggeredAbility;

public final class TriggeredAbilityToken extends Token {
    private TriggeredAbilityToken(final TriggeredAbility triggeredAbility) {
        this.setWord(triggeredAbility);
    }

    static TriggeredAbilityToken fromString(final String s) {
        final TriggeredAbility triggeredAbility =
                TriggeredAbility.fromString(s);
        if (triggeredAbility != null) {
            return new TriggeredAbilityToken(triggeredAbility);
        }
        return null;
    }
}
