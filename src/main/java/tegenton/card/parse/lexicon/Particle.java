package tegenton.card.parse.lexicon;

public enum Particle implements Word {
    DOWN, LEFT, RIGHT, UP;

    @Override
    public String getWord() {
        return this.name();
    }
}
