package game.concepts.symbols.level;

import game.concepts.symbols.Symbol;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LevelMinSymbol extends LevelSymbol {
    private static final Pattern p = Pattern.compile("^LEVEL (\\d+)\\+$");
    private final int min;

    private LevelMinSymbol(int min) {
        this.min = min;
    }

    public static Optional<Symbol> fromString(String s) {
        Matcher m = p.matcher(s);
        if (m.find()) {
            return Optional.of(new LevelMinSymbol(Integer.parseInt(m.group(1))));
        }
        return Optional.empty();
    }

    public int getMin() {
        return min;
    }
}
