package tegenton.card.parse.token.lexicon;

public enum Verb implements Word {
    draw,
    create;

    /**
     * Returns the verb represented by s.
     *
     * @param s string that may contain a verb
     * @return verb contained in s, if s represents one, otherwise null
     */
    public static Verb fromString(final String s) {
        for (final Verb type : Verb.values()) {
            if (type.getWord().equalsIgnoreCase(s)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String getWord() {
        return name();
    }
}
