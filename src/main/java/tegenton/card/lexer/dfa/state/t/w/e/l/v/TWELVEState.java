package tegenton.card.lexer.dfa.state.t.w.e.l.v;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.w.e.l.TWELVState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.Optional;

public class TWELVEState extends TWELVState {
    private static final TWELVEState INSTANCE = new TWELVEState();

    /**
     * @return Singleton instance.
     */
    public static TWELVEState state() {
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
        return switch (c) {
            case '\0', '0' -> Optional.of(EnglishNumber.TWELVE);
            default -> Optional.empty();
        };
    }
}
