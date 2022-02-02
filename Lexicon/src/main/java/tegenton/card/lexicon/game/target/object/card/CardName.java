package tegenton.card.lexicon.game.target.object.card;

import tegenton.card.lexicon.Word;

/**
 * Plague Rats and Wasp.
 */
public enum CardName implements Word {
    PLAGUE,
    RATS,
    WASP;

    @Override
    public String toString() {
        return this.name();
    }
}
