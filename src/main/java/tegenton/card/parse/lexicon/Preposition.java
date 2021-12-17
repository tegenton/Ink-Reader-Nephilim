package tegenton.card.parse.lexicon;

public enum Preposition implements Word {
    ABOVE,
    BEYOND,
    BY,
    FOR,
    FROM,
    IN,
    MINUS,
    OF,
    ON,
    TO,
    UNDER,
    UNTIL,
    WITH;

    @Override
    public String getWord() {
        return this.name();
    }
}
