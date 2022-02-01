package tegenton.card.lexicon.value;

/**
 * A number written out, such as "two" or "seven".
 */
public enum EnglishNumber implements ValueWord {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12),
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(16),
    SEVENTEEN(17),
    EIGHTEEN(18),
    NINETEEN(19),
    TWENTY(20);

    private final int val;

    EnglishNumber(int i) {
        this.val = i;
    }

    @Override
    public String toString() {
        return name();
    }

    public int getValue() {
        return val;
    }
}
