package tegenton.card.parse.dfa.state.d.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.DOState;
import tegenton.card.parse.dfa.state.d.o.n.DONtState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class DONState extends DOState {
    private static final DONState INSTANCE = new DONState();

    /**
     * @return Singleton instance.
     */
    public static DONState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\u2019' -> DONtState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
