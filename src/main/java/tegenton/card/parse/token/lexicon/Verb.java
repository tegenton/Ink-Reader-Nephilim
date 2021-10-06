package tegenton.card.parse.token.lexicon;

public enum Verb implements Word {
    draw,
    create;

    public static Verb fromString(String s) {
        for (Verb type : Verb.values()) {
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
