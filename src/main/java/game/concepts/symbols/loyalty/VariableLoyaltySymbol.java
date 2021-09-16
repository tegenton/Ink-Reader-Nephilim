package game.concepts.symbols.loyalty;

import game.concepts.symbols.Symbol;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class VariableLoyaltySymbol extends LoyaltySymbol {
    private static final Pattern p = Pattern.compile("^\\[?[+-]X]?$");
    private int x;

    private VariableLoyaltySymbol() {
        super();
    }

    public static Optional<Symbol> fromString(String s) {
        Matcher m = p.matcher(s);
        if (m.find()) {
            return Optional.of(new VariableLoyaltySymbol());
        }
        return Optional.empty();
    }

    public int getValue() {
        return x;
    }
}
