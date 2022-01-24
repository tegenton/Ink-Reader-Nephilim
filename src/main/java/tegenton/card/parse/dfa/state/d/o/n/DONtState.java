package tegenton.card.parse.dfa.state.d.o.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.o.DONState;
import tegenton.card.parse.dfa.state.d.o.n.t.DONTState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class DONtState extends DONState {
    private static final DONtState INSTANCE = new DONtState();

    /**
     * @return Singleton instance.
     */
    public static DONtState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> DONTState.state();
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
