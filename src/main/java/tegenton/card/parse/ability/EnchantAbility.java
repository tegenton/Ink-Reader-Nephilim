package tegenton.card.parse.ability;

import tegenton.card.parse.token.Token;
import java.util.List;

public class EnchantAbility extends Ability {
    private EnchantAbility(final List<Token> tokens) {
        super();
    }

    public static EnchantAbility fromTokens(final List<Token> tokens) {
        return new EnchantAbility(tokens);
    }
}
