package tegenton.card.lexicon;

public enum Particle implements Word {
    DOWN, LEFT, RIGHT, UP;

    @Override
    public String getWord() {
        return this.name();
    }
}
