package tegenton.card.lexicon.game.source.target;

import tegenton.card.lexicon.Word;

/**
 * Morphemes that can only apply to a target.
 */
public enum TargetModifier implements Word {
    POSSESSIVE("\u2019s");

    private final String name;

    TargetModifier(final String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
