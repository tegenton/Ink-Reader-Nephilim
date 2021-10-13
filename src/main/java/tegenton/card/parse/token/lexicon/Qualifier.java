package tegenton.card.parse.token.lexicon;

public enum Qualifier implements Word {
    enchanted;

    /**
     * The qualifier that s represents.
     *
     * @param s string that may contain a qualifier
     * @return the represented qualifier or null
     */
    public static Qualifier fromString(final String s) {
        try {
            return Qualifier.valueOf(s.toLowerCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public String getWord() {
        return name().substring(0, 1).toUpperCase() + name().substring(1);
    }
}
