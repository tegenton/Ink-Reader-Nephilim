package tegenton.card.parse.lexicon;

public enum Adverb implements Word {
    OVER;

    @Override
    public String getWord() {
        return this.name();
    }
}
