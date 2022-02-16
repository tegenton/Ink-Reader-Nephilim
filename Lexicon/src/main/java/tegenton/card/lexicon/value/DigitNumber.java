package tegenton.card.lexicon.value;


import java.util.stream.IntStream;

/**
 * A number represented as digits, such as "1" or "2".
 */
public final class DigitNumber implements ValueWord {

    private final int val;

    /**
     * Create a new DigitNumber with the given value.
     *
     * @param i Integer value
     */
    public DigitNumber(final int i) {
        this.val = i;
    }

    /**
     * Generate an array of DigitNumbers.
     *
     * @param i Max value (inclusive).
     * @return Array of DigitNumbers from 0 to i.
     */
    public static DigitNumber[] values(final int i) {
        return IntStream.range(0, i + 1).mapToObj(DigitNumber::new)
                .toArray(DigitNumber[]::new);
    }

    @Override
    public int getValue() {
        return val;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
