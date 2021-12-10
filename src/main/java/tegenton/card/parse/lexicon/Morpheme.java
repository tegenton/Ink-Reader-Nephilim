package tegenton.card.parse.lexicon;

public enum Morpheme implements Word {
    ING,
    S, ER;

    @Override
    public String getWord() {
        return this.name();
    }
}
