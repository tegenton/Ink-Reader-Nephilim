package tegenton.card.parse.lexicon;

public final class Number implements ValueWord {
    private final int value;

    private Number(final int val) {
        this.value = val;
    }

    public static Number valueOf(String s) {
        return new Number(Integer.parseInt(s));
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
