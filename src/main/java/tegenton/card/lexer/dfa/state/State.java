package tegenton.card.lexer.dfa.state;

import tegenton.card.lexicon.Word;

import java.util.Optional;

public abstract class State {

    /**
     * @return Empty instance.
     */
    public static State state() {
        return tegenton.card.lexer.dfa.state.EmptyState.state();
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

    /**
     * @param c Invalid character.
     * @return Exception saying that the character was invalid.
     */
    protected State invalid(final char c) {
        throw new IllegalStateException("Cannot transition from "
                + this.getClass().getSimpleName() + " on "
                + c);
    }
}
