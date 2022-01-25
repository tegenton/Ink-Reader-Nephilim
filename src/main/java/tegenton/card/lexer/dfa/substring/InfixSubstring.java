package tegenton.card.lexer.dfa.substring;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexicon.Word;

import java.util.Optional;
import java.util.function.Supplier;

public class InfixSubstring extends Substring {
    private final char valid;
    private final Supplier<State> out;

    /**
     * A substring that leads to one or more states rather than just a word.
     *
     * @param sequence   Series of characters to transition on.
     * @param transition Final character.
     * @param nextState  State to transition to after final character.
     */
    public InfixSubstring(final String sequence,
                          final char transition,
                          final Supplier<State> nextState) {
        super(sequence.toCharArray());
        this.valid = transition;
        this.out = nextState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        if (completed() && c == valid) {
            return out.get();
        } else {
            return super.transition(c);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
