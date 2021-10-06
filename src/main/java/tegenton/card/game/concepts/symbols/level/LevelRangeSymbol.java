package tegenton.card.game.concepts.symbols.level;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LevelRangeSymbol extends LevelSymbol {
    private static final Pattern p = Pattern.compile("^LEVEL (\\d+)-(\\d+)$");
    private final int max;
    private final int min;

    private LevelRangeSymbol(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static LevelRangeSymbol fromString(String s) {
        Matcher m = p.matcher(s);
        if (m.find()) {
            int min = Integer.parseInt(m.group(1));
            int max = Integer.parseInt(m.group(2));
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
