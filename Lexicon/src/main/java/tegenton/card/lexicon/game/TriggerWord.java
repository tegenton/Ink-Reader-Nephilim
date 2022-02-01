package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

/**
 * "When", "whenever", or "at" each indicate the start of a triggered ability.
 */
public enum TriggerWord implements Word {
    WHEN,
    WHENEVER,
    AT;

    @Override
    public String toString() {
        return this.name();
    }
}
