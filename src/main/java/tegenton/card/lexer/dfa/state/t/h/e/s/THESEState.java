package tegenton.card.lexer.dfa.state.t.h.e.s;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.h.e.THESState;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class THESEState extends THESState {
    private static final THESEState INSTANCE = new THESEState();

    /**
     * @return Singleton instance.
     */
    public static THESEState state() {
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
            case ' ', '\0' -> Determiner.THESE;
            default -> null;
        });
    }
}
