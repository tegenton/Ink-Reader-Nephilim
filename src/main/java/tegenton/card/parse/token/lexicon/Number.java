package tegenton.card.parse.token.lexicon;

public class Number implements Word {
    final int val;

    public Number(int val) {
        this.val = val;
    }

    public static Number fromString(String s) {
        int val;
        try {
            val = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
        return new Number(val);
    }

    @Override
    public String getWord() {
        return Integer.toString(val);
    }

    public int getVal() {
        return val;
    }
}
