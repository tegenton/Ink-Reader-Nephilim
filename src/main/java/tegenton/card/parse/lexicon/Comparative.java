package tegenton.card.parse.lexicon;

public enum Comparative implements Word {
    GREATER,
    LESS,
    MORE;

    @Override
    public String getWord() {
        return this.name();
    }
}
