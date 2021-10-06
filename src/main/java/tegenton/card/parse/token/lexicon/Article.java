package tegenton.card.parse.token.lexicon;

public enum Article implements Word {
    a,
    an;

    public static Article fromString(String s) {
        for (Article type : Article.values()) {
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
