package tegenton.card.parse.ability;

import tegenton.card.parse.token.KeywordAbilityToken;
import tegenton.card.parse.token.TokenStream;
import tegenton.card.parse.token.TriggeredAbilityToken;

public abstract class Ability {
    /**
     * Directs the stream of tokens to the correct ability parser.
     *
     * @param tokens A stream of tokens containing an ability.
     * @return The ability the tokens form.
     */
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
