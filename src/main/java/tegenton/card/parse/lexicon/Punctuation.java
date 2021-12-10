package tegenton.card.parse.lexicon;

public enum Punctuation implements Word {
    PERIOD("."),
    COMMA(","),
    SPACE(" ");

    private final String name;

    Punctuation(final String s) {
        name = s;
    }

    @Override
    public String getWord() {
        return name;
    }
}
