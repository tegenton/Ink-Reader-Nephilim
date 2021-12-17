package tegenton.card.parse.lexicon;

public enum Preposition implements Word {
    ABOVE,
    BEYOND,
    FOR,
    FROM,
    IN,
    OF,
    ON,
    TO,
    UNDER,
    WITH;

    @Override
    public String getWord() {
        return this.name();
    }
}
