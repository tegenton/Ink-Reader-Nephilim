package tegenton.card.parse.lexicon;

public enum Adjective implements Word {
    CHOSEN, DIFFERENT, EQUAL, EXTRA, FIRST, NEW, NEXT, ROUNDED, SAME;

    @Override
    public String getWord() {
        return this.name();
    }
}
