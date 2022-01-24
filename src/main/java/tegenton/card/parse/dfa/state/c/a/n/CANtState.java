package tegenton.card.parse.dfa.state.c.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.a.CANState;
import tegenton.card.parse.dfa.state.c.a.n.t.CANTState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class CANtState extends CANState {
    private static final CANtState INSTANCE = new CANtState();

    /**
     * @return Singleton instance.
     */
    public static CANtState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> CANTState.state();
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
