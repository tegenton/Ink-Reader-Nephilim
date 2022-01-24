package tegenton.card.parse.dfa.state.t.h.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.t.h.THAState;
import tegenton.card.parse.lexicon.Comparative;
import tegenton.card.parse.lexicon.Word;

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
