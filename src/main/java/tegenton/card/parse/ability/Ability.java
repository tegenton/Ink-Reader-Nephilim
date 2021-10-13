package tegenton.card.parse.ability;

import tegenton.card.parse.token.KeywordAbilityToken;
import tegenton.card.parse.token.TokenStream;
import tegenton.card.parse.token.TriggeredAbilityToken;

public abstract class Ability {
    public static Ability fromStream(final TokenStream tokens) {
        if (!tokens.hasNext()) {
            return null;
        } else if (tokens.checkNext() instanceof KeywordAbilityToken) {
            return EnchantAbility.fromStream(tokens);
        } else if (tokens.checkNext() instanceof TriggeredAbilityToken) {
            return TriggeredAbility.fromStream(tokens);
        } else {
            return StaticAbility.fromStream(tokens);
        }
    }
}
