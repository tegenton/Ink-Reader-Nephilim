package tegenton.card.parse.ability;

import tegenton.card.parse.token.TokenStream;

public class StaticAbility extends Ability {
    public static StaticAbility fromStream(TokenStream tokens) {
        return new StaticAbility();
    }
}
