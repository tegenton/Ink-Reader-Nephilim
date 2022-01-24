package tegenton.card.parse.lexicon;

public enum Genitive implements Word {
    HALF;

    @Override
    public String getWord() {
        return this.name();
    }
}
