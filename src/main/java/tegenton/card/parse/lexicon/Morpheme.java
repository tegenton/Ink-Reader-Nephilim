package tegenton.card.parse.lexicon;

public enum Morpheme implements Word {
    ER,
    ING,
    S;

    @Override
    public String getWord() {
        return this.name();
    }
}
