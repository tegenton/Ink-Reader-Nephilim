package tegenton.card.parse.lexicon;

public enum Adjective implements Word {
    CHOSEN, DIFFERENT, EQUAL, FIRST;

    @Override
    public String getWord() {
        return this.name();
    }
}
