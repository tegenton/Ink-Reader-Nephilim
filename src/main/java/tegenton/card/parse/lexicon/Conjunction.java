package tegenton.card.parse.lexicon;

public enum Conjunction implements Word {
    AND,
    OR,
    THEN;

    @Override
    public String getWord() {
        return this.name();
    }
}
