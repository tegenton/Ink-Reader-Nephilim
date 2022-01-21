package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public abstract class State {

    public static State state() {
        return EmptyState.state();
    }

    /**
     * Move to the next state.
     *
     * @param c Character to transition on.
     * @return State transitioned to.
     */
    public abstract State transition(char c);

    /**
     * Get products of the next transition.
     *
     * @param c Character that will be transitioned on
     * @return Optional containing the product of that transition, if any.
     */
    public abstract Optional<? extends Word> produce(char c);

    protected State invalid(final char c) {
        throw new IllegalStateException("Cannot transition from "
                + this.getClass().getSimpleName() + " on "
                + c);
    }
}
