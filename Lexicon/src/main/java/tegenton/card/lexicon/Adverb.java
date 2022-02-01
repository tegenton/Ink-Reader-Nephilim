package tegenton.card.lexicon;

public enum Adverb implements Word {
    BACK,
    COMPLETELY,
    EVENLY,
    INSTEAD,
    LIKEWISE,
    NOT,
    ONCE,
    ONLY,
    OVER,
    STILL;

    @Override
    public String toString() {
        return this.name();
    }
}
