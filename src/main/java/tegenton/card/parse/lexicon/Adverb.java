package tegenton.card.parse.lexicon;

public enum Adverb implements Word {
    LIKEWISE, ONLY, OVER, STILL;

    @Override
    public String getWord() {
        return this.name();
    }
}
