package tegenton.card.parse.lexicon;

/**
 * The (grammatical) object of a sentence.
 */
public enum ObjectWord implements Word {
    CARD,
    COPY,
    PERMANENT,
    SPELL,
    IT;

    @Override
    public String getWord() {
        return this.name();
    }
}
