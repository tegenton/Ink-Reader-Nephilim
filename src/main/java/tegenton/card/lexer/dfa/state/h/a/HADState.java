package tegenton.card.lexer.dfa.state.h.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.h.HAState;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class HADState extends HAState {
    private static final HADState INSTANCE = new HADState();

    /**
     * @return Singleton instance.
     */
    public static HADState state() {
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
            case '\0', ' ' -> Morpheme.ED;
            default -> null;
        });
    }
}
