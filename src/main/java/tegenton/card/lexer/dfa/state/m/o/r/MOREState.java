package tegenton.card.lexer.dfa.state.m.o.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.m.o.MORState;
import tegenton.card.lexicon.Comparative;

import java.util.Optional;

public class MOREState extends MORState {
    private static final MOREState INSTANCE = new MOREState();

    /**
     * @return Singleton instance.
     */
    public static MOREState state() {
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
            case '\0', ' ' -> Comparative.MORE;
            default -> null;
        });
    }
}
