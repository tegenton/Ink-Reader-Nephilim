package tegenton.card.parse.token.lexicon;

public enum Punctuation implements Word {
    period("."),
    comma(",");

    private final String name;

    Punctuation(final String s) {
        name = s;
    }

    /**
     * Returns the punctuation represented by s.
     *
     * @param s string that may contain punctuation, such as "."
     * @return punctuation contained in s, if s represents one, otherwise null
     */
    public static Punctuation fromString(final String s) {
        for (final Punctuation type : Punctuation.values()) {
            if (type.getWord().equalsIgnoreCase(s)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String getWord() {
        return name;
    }
}
