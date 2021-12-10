package tegenton.card.parse.lexicon;

/**
 * A number written out, such as "two" or "seven". This enum contains zero to
 * twenty.
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
    EIGHt(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12),
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(16),
    SEVEnTEEN(17),
    EIGHTEEN(18),
    NINETEEN(19),
    TWENTY(20);

    private final int val;

    EnglishNumber(final int numberValue) {
        this.val = numberValue;
    }

    @Override
    public String getWord() {
        return name();
    }

    /**
     * @return the value of the number
     */
    public int getVal() {
        return val;
    }
}
