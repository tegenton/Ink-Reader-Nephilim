package tegenton.card.parse.ability;

import tegenton.card.parse.token.TokenStream;
import tegenton.card.parse.token.lexicon.KeywordAbility;

public class EnchantAbility extends Ability {
    public EnchantAbility(TokenStream tokens) {
        super();
    }

    public static EnchantAbility fromStream(final TokenStream tokens) {
        if (tokens.checkNext().getWord().equals(KeywordAbility.enchant))
            tokens.getNext();
        return new EnchantAbility(tokens);
    }
}
