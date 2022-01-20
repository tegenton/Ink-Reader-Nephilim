package tegenton.card.parse.lexicon.value;

public final class Number implements ValueWord {
    public static Number ONE = new Number(1);
    public static Number TWO = new Number(2);
    public static Number THREE = new Number(3);
    public static Number FOUR = new Number(4);
    public static Number FIVE = new Number(5);

    private final int value;

    public Number(final int val) {
        this.value = val;
    }

    public static Number valueOf(String s) {
        return new Number(Integer.parseInt(s));
    }

    public static Number valueOf(int i) {
        return new Number(i);
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

    public boolean equals(Object o) {
        if (o instanceof Number n) {
            return n.getVal() == this.getVal();
        }
        return false;
    }
}
