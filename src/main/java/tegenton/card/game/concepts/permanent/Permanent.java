package tegenton.card.game.concepts.permanent;


/**
 * A permanent is a card or token on the battlefield. It can be tapped/untapped,
 * flipped/unflipped, face up/down, and phased in/out. It must have a value for
 * each of these four categories at all times, which starts as untapped,
 * unflipped, face up, and phased in.
 */
public interface Permanent {
    /**
     * Retrieve an aspect of current state of a permanent.
     *
     * @param category tapped, flipped, face, or phase
     * @return False if this permanent has the default state, true otherwise.
     */
    boolean getState(State category);

    /**
     * Set a particular aspect of a permanent's state.
     *
     * @param category tapped, flipped, face, or phase
     * @param value    False to give this permanent the default state,
     *                 true otherwise.
     */
    void setState(State category, boolean value);

    /**
     * Toggle a particular aspect of this permanent's state.
     *
     * @param category tapped, flipped, face, or phase
     */
    void toggleState(State category);
}
