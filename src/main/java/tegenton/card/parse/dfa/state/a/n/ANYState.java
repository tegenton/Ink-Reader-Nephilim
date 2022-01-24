package tegenton.card.parse.dfa.state.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.ANState;
import tegenton.card.parse.lexicon.Determiner;

import java.util.Optional;

public class ANYState extends ANState {
    private static final ANYState INSTANCE = new ANYState();

    /**
     * @return Singleton instance.
     */
    public static ANYState state() {
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
    public Optional<Determiner> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Determiner.ANY;
            default -> null;
        });
    }
}
