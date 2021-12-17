package tegenton.card.parse.lexicon;

public enum Adjective implements Word {
    CHOSEN, DIFFERENT, EQUAL, FIRST, NEW, NEXT;

    @Override
    public String getWord() {
        return this.name();
    }
}
