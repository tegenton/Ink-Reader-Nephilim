package tegenton.card.parse.lexicon;

public enum Adverb implements Word {
    BACK, COMPLETELY, EVENLY, INSTEAD, LIKEWISE, NOT, ONCE, ONLY, OVER, STILL;

    @Override
    public String getWord() {
        return this.name();
    }
}
