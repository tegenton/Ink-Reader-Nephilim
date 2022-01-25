package tegenton.card.lexer.dfa.state.b;

import tegenton.card.lexer.dfa.state.BState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class BYState extends BState {
    private static final BYState INSTANCE = new BYState();

    /**
     * @return Singleton instance.
     */
    public static BYState state() {
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
            case '\0', ' ' -> Preposition.BY;
            default -> null;
        });
    }
}
