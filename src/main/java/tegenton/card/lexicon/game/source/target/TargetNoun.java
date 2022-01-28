package tegenton.card.lexicon.game.source.target;

/**
 * Nouns that can refer to either an object or a player.
 */
public enum TargetNoun implements TargetWord {
    THEM, THEY, WHO;

    @Override
    public String getWord() {
        return this.name();
    }
}
