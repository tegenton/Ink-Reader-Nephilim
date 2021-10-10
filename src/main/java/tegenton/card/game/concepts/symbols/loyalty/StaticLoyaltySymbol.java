package tegenton.card.game.concepts.symbols.loyalty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class StaticLoyaltySymbol extends LoyaltySymbol {
    private static final Pattern PATTERN =
            Pattern.compile("^\\[?([+-][1-9]+|0)]?$");
    private final int value;

    private StaticLoyaltySymbol(final int symbolValue) {
        this.value = symbolValue;
    }

    public static StaticLoyaltySymbol fromString(final String s) {
        final Matcher m = PATTERN.matcher(s);
        if (m.find()) {
            return new StaticLoyaltySymbol(Integer.parseInt(m.group(1)));
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
