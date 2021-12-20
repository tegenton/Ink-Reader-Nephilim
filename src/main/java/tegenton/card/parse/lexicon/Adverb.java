package tegenton.card.parse.lexicon;

public enum Adverb implements Word {
    BACK, COMPLETELY, EVENLY, LIKEWISE, ONLY, OVER, STILL;

    @Override
    public String getWord() {
        return this.name();
    }
}
