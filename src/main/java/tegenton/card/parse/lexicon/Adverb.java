package tegenton.card.parse.lexicon;

public enum Adverb implements Word {
    BACK, COMPLETELY, EVENLY, INSTEAD, LIKEWISE, ONCE, ONLY, OVER, STILL;

    @Override
    public String getWord() {
        return this.name();
    }
}
