package tegenton.card.parse.lexicon;

public enum Punctuation implements Word {
    period("."),
    comma(",");

    private final String name;

    Punctuation(final String s) {
        name = s;
    }

    @Override
    public String getWord() {
        return name;
    }
}
