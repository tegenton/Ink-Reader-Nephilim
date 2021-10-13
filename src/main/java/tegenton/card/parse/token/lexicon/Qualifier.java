package tegenton.card.parse.token.lexicon;

public enum Qualifier implements Word {
    enchanted;

    public static Qualifier fromString(String s) {
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
