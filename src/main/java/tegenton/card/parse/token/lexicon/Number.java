package tegenton.card.parse.token.lexicon;

public final class Number implements Word {
    private final int value;

    private Number(final int val) {
        this.value = val;
    }

    /**
     * A number, such as 3 or 12.
     *
     * @param s a string containing a number
     * @return Number object containing that value
     */
    public static Number fromString(final String s) {
        final int val;
        try {
            val = Integer.parseInt(s);
        } catch (final NumberFormatException e) {
            return null;
        }
        return new Number(val);
    }

    @Override
    public String getWord() {
        return Integer.toString(value);
    }

    /**
     * Retrieve the actual value of the original string.
     *
     * @return the number as an integer
     */
    public int getVal() {
        return value;
    }
}
