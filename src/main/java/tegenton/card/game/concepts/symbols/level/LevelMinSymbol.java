package tegenton.card.game.concepts.symbols.level;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LevelMinSymbol extends LevelSymbol {
    private static final Pattern p = Pattern.compile("^LEVEL (\\d+)\\+$");
    private final int min;

    private LevelMinSymbol(int min) {
        this.min = min;
    }

    public static LevelMinSymbol fromString(String s) {
        Matcher m = p.matcher(s);
        if (m.find()) {
            return new LevelMinSymbol(Integer.parseInt(m.group(1)));
        }
        return null;
    }

    public int getMin() {
        return min;
    }
}
