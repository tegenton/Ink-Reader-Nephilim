package tegenton.card.parse.token.lexicon;

import java.util.Optional;

public class Number implements Word {
    int val;

    public Number(int val) {
        this.val = val;
    }

    public static Optional<Number> fromString(String s) {
        int val;
        try {
            val = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
        return Optional.of(new Number(val));
    }

    @Override
    public String getWord() {
        return Integer.toString(val);
    }

    public int getVal() {
        return val;
    }
}
