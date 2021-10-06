package tegenton.card.game.concepts.symbols.loyalty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StaticLoyaltySymbol extends LoyaltySymbol {
    private static final Pattern p = Pattern.compile("^\\[?([+-][1-9]+|0)]?$");
    private final int value;

    private StaticLoyaltySymbol(int value) {
        this.value = value;
    }

    public static StaticLoyaltySymbol fromString(String s) {
        Matcher m = p.matcher(s);
        if (m.find()) {
            return new StaticLoyaltySymbol(Integer.parseInt(m.group(1)));
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
