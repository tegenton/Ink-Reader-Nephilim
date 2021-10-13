package tegenton.card.parse.ability;

import tegenton.card.parse.token.TokenStream;
import tegenton.card.parse.token.lexicon.KeywordAbility;

/**
 * Enchant is a static ability, written “Enchant [object or player].” The
 * enchant ability restricts what an Aura spell can target and what an Aura can
 * enchant.
 */
public final class EnchantAbility extends Ability {
    private EnchantAbility(final TokenStream tokens) {

    }

    /**
     * Consume "Enchant" and an object or player from the token stream.
     *
     * @param tokens Stream of tokens starting with an enchant ability.
     * @return Enchant ability with a target as specified in the stream.
     */
    public static EnchantAbility fromStream(final TokenStream tokens) {
        if (tokens.checkNext().getWord().equals(KeywordAbility.enchant)) {
            tokens.getNext();
        }
        return new EnchantAbility(tokens);
    }
}
