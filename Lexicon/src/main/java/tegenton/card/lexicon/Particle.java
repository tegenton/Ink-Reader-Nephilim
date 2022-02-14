package tegenton.card.lexicon;

/**
 * Particles are words only used in certain contexts.
 */
public enum Particle implements Word {
    DOWN,
    LEFT,
    RIGHT,
    UP;

    @Override
    public String toString() {
        return this.name();
    }
}
