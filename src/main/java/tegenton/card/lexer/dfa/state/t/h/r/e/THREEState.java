package tegenton.card.lexer.dfa.state.t.h.r.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.h.r.THREState;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.Optional;

public class THREEState extends THREState {
    private static final THREEState INSTANCE = new THREEState();

    /**
     * @return Singleton instance.
     */
    public static THREEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> throw new IllegalStateException(
                    "Cannot transition from THREEState on " + c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<EnglishNumber> produce(final char c) {
        return switch (c) {
            case ' ', '\0' -> Optional.of(EnglishNumber.THREE);
            default -> Optional.empty();
        };
    }
}
