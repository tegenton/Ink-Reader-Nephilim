package tegenton.card.parse.token.lexicon;

public enum KeywordAction implements Word {
    scry,
    fateseal;

    public static KeywordAction fromString(String s) {
        for (KeywordAction type : KeywordAction.values()) {
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
