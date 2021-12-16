package tegenton.card.parse.lexicon;

public enum SubordinateConjunction implements Word {
    AS, BUT, EXCEPT, IF, LONG, WHERE;

    @Override
    public String getWord() {
        return this.name();
    }
}
