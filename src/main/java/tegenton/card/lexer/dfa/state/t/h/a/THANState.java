package tegenton.card.lexer.dfa.state.t.h.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.h.THAState;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class THANState extends THAState {
    private static final THANState INSTANCE = new THANState();

    /**
     * @return Singleton instance.
     */
    public static THANState state() {
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
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Comparative.THAN;
            default -> null;
        });
    }
}
