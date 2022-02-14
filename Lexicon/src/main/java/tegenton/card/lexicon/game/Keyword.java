package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

/**
 * Keywords can represent static or triggered abilities.
 */
public enum Keyword implements Word {
    BANDING,
    DEFENDER,
    ENCHANT,
    FEAR,
    FLYING,
    HASTE,
    INDESTRUCTIBLE,
    PROTECTION,
    REACH,
    STRIKE,
    TRAMPLE,
    VIGILANCE,
    WALK;

    @Override
    public String toString() {
        return this.name();
    }
}
