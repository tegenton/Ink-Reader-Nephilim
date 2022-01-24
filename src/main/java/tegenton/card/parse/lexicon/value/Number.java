package tegenton.card.parse.lexicon.value;

import java.util.Objects;

public final class Number implements ValueWord {
    public static final Number ZERO = new Number(0);
    public static final Number ONE = new Number(1);
    public static final Number TWO = new Number(2);
    public static final Number THREE = new Number(3);
    public static final Number FOUR = new Number(4);
    public static final Number FIVE = new Number(5);

    private final int value;

    public Number(final int i) {
        this.value = i;
    }

    public static Number valueOf(final String s) {
        return new Number(Integer.parseInt(s));
    }

    public static Number valueOf(final int i) {
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

    public boolean equals(final Object o) {
        if (o instanceof Number n) {
            return n.getVal() == this.getVal();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
