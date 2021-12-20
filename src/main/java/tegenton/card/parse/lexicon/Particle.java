package tegenton.card.parse.lexicon;

public enum Particle implements Word {
    DOWN, UP;

    @Override
    public String getWord() {
        return this.name();
    }
}
