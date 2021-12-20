package tegenton.card.parse.lexicon;

public enum Preposition implements Word {
    ABOVE,
    AMONG,
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
    WITH;

    @Override
    public String getWord() {
        return this.name();
    }
}
