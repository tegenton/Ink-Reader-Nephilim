package tegenton.card.parse.lexicon;

/**
 * A number written out, such as "two" or "seven".
 * This enum contains zero to twenty.
 */
public enum EnglishNumber implements ValueWord {
    zero(0),
    one(1),
    two(2),
    three(3),
    four(4),
    five(5),
    six(6),
    seven(7),
    eight(8),
    nine(9),
    ten(10),
    eleven(11),
    twelve(12),
    thirteen(13),
    fourteen(14),
    fifteen(15),
    sixteen(16),
    seventeen(17),
    eighteen(18),
    nineteen(19),
    twenty(20);

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
