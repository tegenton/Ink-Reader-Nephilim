package tegenton.card.parse.lexicon;

public enum Adjective implements Word {
    CHOSEN;

    @Override
    public String getWord() {
        return this.name();
    }
}
