package tegenton.card.lexer.dfa.state.t.a.r.g.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.t.a.r.g.TARGEState;
import tegenton.card.lexicon.Determiner;

import java.util.Optional;

public final class TARGETState extends TARGEState {
    private static final TARGETState INSTANCE = new TARGETState();

    /**
     * @return Singleton instance.
     */
    public static TARGETState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Determiner> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\0', '.', ' ' -> Determiner.TARGET;
            default -> null;
        });
    }
}
