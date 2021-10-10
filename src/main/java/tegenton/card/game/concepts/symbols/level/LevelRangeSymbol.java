package tegenton.card.game.concepts.symbols.level;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class LevelRangeSymbol extends LevelSymbol {
    private static final Pattern PATTERN =
            Pattern.compile("^LEVEL (\\d+)-(\\d+)$");
    private final int max;
    private final int min;

    private LevelRangeSymbol(final int minLevel, final int maxLevel) {
        this.min = minLevel;
        this.max = maxLevel;
    }

    public static LevelRangeSymbol fromString(final String s) {
        final Matcher m = PATTERN.matcher(s);
        if (m.find()) {
            final int min = Integer.parseInt(m.group(1));
            final int max = Integer.parseInt(m.group(2));
            return new LevelRangeSymbol(min, max);
        }
        return null;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
