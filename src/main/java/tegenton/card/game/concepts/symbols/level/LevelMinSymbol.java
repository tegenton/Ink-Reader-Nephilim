package tegenton.card.game.concepts.symbols.level;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class LevelMinSymbol extends LevelSymbol {
    private static final Pattern PATTERN = Pattern.compile("^LEVEL (\\d+)\\+$");
    private final int min;

    private LevelMinSymbol(final int minLevel) {
        this.min = minLevel;
    }

    public static LevelMinSymbol fromString(final String s) {
        final Matcher m = PATTERN.matcher(s);
        if (m.find()) {
            return new LevelMinSymbol(Integer.parseInt(m.group(1)));
        }
        return null;
    }

    public int getMin() {
        return min;
    }
}
