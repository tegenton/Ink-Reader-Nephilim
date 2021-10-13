package tegenton.card.parse.ability;

import tegenton.card.parse.token.TokenStream;

/**
 * Static abilities are written as statements. They’re simply true. Static
 * abilities create continuous effects which are active while the permanent with
 * the ability is on the battlefield and has the ability, or while the object
 * with the ability is in the appropriate zone.
 */
public class StaticAbility extends Ability {
    /**
     * Consume a static ability from the stream.
     *
     * @param tokens Stream of tokens starting with a static ability.
     * @return A static ability as specified in the stream.
     */
    public static StaticAbility fromStream(final TokenStream tokens) {
        return new StaticAbility();
    }
}
