package tegenton.card.parse.lexicon;

public enum Morpheme implements Word {
    ING;

    @Override
    public String getWord() {
        return this.name();
    }
}
