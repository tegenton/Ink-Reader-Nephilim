package tegenton.card.game.concepts.token;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Some effects instruct a player to create a legendary token.
 * These may be written “create [name], a . . .” and list characteristics for
 * the token. This is the same as an instruction to create a token with the
 * listed characteristics that has the given name.
 */
public abstract class LegendaryToken extends Token {
    private static final Pattern PATTERN = Pattern.compile("^(.*), a (.*)$");

    /**
     * Create a token formatted using the legendary format.
     *
     * @param s string containing instructions to "create [name], a..."
     * @return a token of [name]
     */
    public static Token create(final String s) {
        final Matcher m = PATTERN.matcher(s);
        if (m.find()) {
            final Token token = Token.create(m.group(2));
            token.setName(List.of(m.group(1)));
            return token;
        } else {
            return null;
        }
    }
}
