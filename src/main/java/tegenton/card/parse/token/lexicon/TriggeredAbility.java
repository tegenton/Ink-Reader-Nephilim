package tegenton.card.parse.token.lexicon;

public enum TriggeredAbility implements Word {
    when,
    whenever,
    at;

    /**
     * The trigger word that s represents (Whenever, When, or At).
     *
     * @param s string that may contain a trigger word
     * @return the represented word or null
     */
    public static TriggeredAbility fromString(final String s) {
        try {
            return TriggeredAbility.valueOf(s.toLowerCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public String getWord() {
        return name().substring(0, 1).toUpperCase() + name().substring(1);
    }
}
