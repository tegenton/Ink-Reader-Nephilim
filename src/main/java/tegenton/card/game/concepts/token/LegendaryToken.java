package tegenton.card.game.concepts.token;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class LegendaryToken extends Token {
    private static final Pattern legend = Pattern.compile("^(.*), a (.*)$");

    public static Token create(String s) {
        Matcher m = legend.matcher(s);
        if (m.find()) {
            Token token = Token.create(m.group(2));
            token.setName(List.of(m.group(1)));
            return token;
        } else {
            return null;
        }
    }
}
