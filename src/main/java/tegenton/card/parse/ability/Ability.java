package tegenton.card.parse.ability;

import tegenton.card.parse.token.Token;
import tegenton.card.parse.token.lexicon.KeywordAbility;
import java.util.List;

public abstract class Ability {
    public static Ability fromString(final String s) {
        final List<Token> tokens = Token.tokenize(s);
        if (tokens.get(0).getWord().equals(KeywordAbility.enchant)) {
            return EnchantAbility.fromTokens(tokens);
        }
        return new StaticAbility();
    }
}
