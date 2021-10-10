package tegenton.card.game.concepts.symbols.loyalty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class VariableLoyaltySymbol extends LoyaltySymbol {
    private static final Pattern PATTERN = Pattern.compile("^\\[?[+-]X]?$");
    private final int value = 0;

    private VariableLoyaltySymbol() {
        super();
    }

    public static VariableLoyaltySymbol fromString(final String s) {
        final Matcher m = PATTERN.matcher(s);
        if (m.find()) {
            return new VariableLoyaltySymbol();
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
