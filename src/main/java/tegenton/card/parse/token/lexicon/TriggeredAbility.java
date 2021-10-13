package tegenton.card.parse.token.lexicon;

public enum TriggeredAbility implements Word {
    when,
    whenever,
    at;

    public static TriggeredAbility fromString(String s) {
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
