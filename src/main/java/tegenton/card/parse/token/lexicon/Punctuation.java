package tegenton.card.parse.token.lexicon;

public enum Punctuation implements Word {
    period("."),
    comma(",");

    private final String name;

    Punctuation(String s) {
        name = s;
    }

    public static Punctuation fromString(String s) {
        for (Punctuation type : Punctuation.values()) {
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
