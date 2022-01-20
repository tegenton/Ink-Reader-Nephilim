package tegenton.card.parse.lexicon;

public enum Preposition implements Word {
    ABOVE,
    ADDITION,
    AMONG,
    BEYOND,
    BY,
    FOR,
    FROM,
    IN,
    MINUS,
    OF,
    ON,
    OUT,
    TO,
    UNDER,
    WITH;

    @Override
    public String getWord() {
        return this.name();
    }
}
