package tegenton.card.game.concepts.symbols.loyalty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class VariableLoyaltySymbol extends LoyaltySymbol {
    private static final Pattern p = Pattern.compile("^\\[?[+-]X]?$");
    private int value = 0;

    private VariableLoyaltySymbol() {
        super();
    }

    public static VariableLoyaltySymbol fromString(String s) {
        Matcher m = p.matcher(s);
        if (m.find()) {
            return new VariableLoyaltySymbol();
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
