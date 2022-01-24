package tegenton.card.parse.dfa.state.l.e.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.l.e.LESState;
import tegenton.card.parse.lexicon.Comparative;

import java.util.Optional;

public class LESSState extends LESState {
    private static final LESSState INSTANCE = new LESSState();

    /**
     * @return Singleton instance.
     */
    public static LESSState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Comparative> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Comparative.LESS;
            default -> null;
        });
    }
}
