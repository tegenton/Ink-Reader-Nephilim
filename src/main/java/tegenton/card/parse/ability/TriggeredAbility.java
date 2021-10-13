package tegenton.card.parse.ability;

import tegenton.card.parse.token.TokenStream;

public class TriggeredAbility extends Ability {
    public static TriggeredAbility fromStream(TokenStream tokens) {
        return new TriggeredAbility();
    }
}
