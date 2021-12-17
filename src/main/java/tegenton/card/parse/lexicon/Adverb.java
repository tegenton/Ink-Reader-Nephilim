package tegenton.card.parse.lexicon;

public enum Adverb implements Word {
    LIKEWISE, OVER;

    @Override
    public String getWord() {
        return this.name();
    }
}
