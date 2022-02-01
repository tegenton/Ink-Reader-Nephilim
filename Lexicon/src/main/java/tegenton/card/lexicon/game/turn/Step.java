package tegenton.card.lexicon.game.turn;

import tegenton.card.lexicon.Word;

/**
 * The steps of a turn are untap, upkeep, draw, beginning of combat, declare
 * attackers, declare blockers, combat damage, end of combat, end, and cleanup.
 */
public enum Step implements Word {
    UPKEEP,
    END;

    @Override
    public String toString() {
        return this.name();
    }
}
