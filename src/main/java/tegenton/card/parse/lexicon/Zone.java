package tegenton.card.parse.lexicon;

public enum Zone implements Word {
    ANTE,
    BATTLEFIELD,
    EXILE,
    GRAVEYARD,
    HAND,
    LIBRARY;

    @Override
    public String getWord() {
        return this.name();
    }
}
