package tegenton.card.parse.lexicon;

import java.util.Optional;

public enum EnglishNumber implements Word {
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

    EnglishNumber(int val) {
        this.val = val;
    }

    public static Optional<EnglishNumber> fromString(String s) {
        for (EnglishNumber type : EnglishNumber.values()) {
            if (type.getWord().equalsIgnoreCase(s)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String getWord() {
        return name();
    }

    public int getVal() {
        return val;
    }
}
