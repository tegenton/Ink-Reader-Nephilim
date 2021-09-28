package tegenton.card.game.concepts.symbols.loyalty;

import tegenton.card.game.concepts.symbols.Symbol;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StaticLoyaltySymbol extends LoyaltySymbol {
    private static final Pattern p = Pattern.compile("^\\[?([+-][1-9]+|0)]?$");
    private final int value;

    private StaticLoyaltySymbol(int value) {
        this.value = value;
    }

    public static Optional<Symbol> fromString(String s) {
        Matcher m = p.matcher(s);
        if (m.find()) {
            return Optional.of(new StaticLoyaltySymbol(Integer.parseInt(m.group(1))));
        }
        return Optional.empty();
    }

    public int getValue() {
        return value;
    }
}
