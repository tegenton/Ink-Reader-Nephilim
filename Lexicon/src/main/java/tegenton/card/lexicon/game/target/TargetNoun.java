package tegenton.card.lexicon.game.target;

/**
 * Nouns representing an object.
 */
public enum TargetNoun implements TargetWord {
    THEM,
    THEY,
    WHO;

    @Override
    public String toString() {
        return this.name();
    }
}