package tegenton.card.lexer.dfa.state.g.r.e.a.t.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.g.r.e.a.t.GREATEState;
import tegenton.card.lexicon.Comparative;

import java.util.Optional;

public class GREATERState extends GREATEState {
    private static final GREATERState INSTANCE = new GREATERState();

    /**
     * @return Singleton instance.
     */
    public static GREATERState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Comparative> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ',', ' ' -> Comparative.GREATER;
            default -> null;
        });
    }
}
