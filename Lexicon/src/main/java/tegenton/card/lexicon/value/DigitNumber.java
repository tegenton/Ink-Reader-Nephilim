package tegenton.card.lexicon.value;

import java.util.stream.IntStream;

public final class DigitNumber implements ValueWord {

    private final int val;

    public DigitNumber(int i) {
        this.val = i;
    }

    public static DigitNumber[] values() {
        return IntStream.range(0, 20).mapToObj(DigitNumber::new)
                .toArray(DigitNumber[]::new);
    }

    @Override
    public int getValue() {
        return val;
    }
}
