package tegenton.card.lexicon;

public enum SubordinateConjunction implements Word {
    AS, BUT, EXCEPT, IF, LONG, THOUGH, WHERE;

    @Override
    public String getWord() {
        return this.name();
    }
}
