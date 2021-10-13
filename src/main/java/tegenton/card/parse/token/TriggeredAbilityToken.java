package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.TriggeredAbility;

public class TriggeredAbilityToken extends Token {
    public TriggeredAbilityToken(TriggeredAbility triggeredAbility) {
        super();
        this.setWord(triggeredAbility);
    }

    public static TriggeredAbilityToken fromString(String s) {
        final TriggeredAbility triggeredAbility = TriggeredAbility.fromString(s);
        if (triggeredAbility != null) {
            return new TriggeredAbilityToken(triggeredAbility);
        }
        return null;
    }
}
