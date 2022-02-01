package tegenton.card.lexer.dfa.state;

import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.Variable;

import java.util.Optional;

public class XState extends tegenton.card.lexer.dfa.state.State {
    private static final XState INSTANCE = new XState();

    /**
     * @return Singleton instance.
     */
    public static XState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', '}', '.', '/', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '}', '.', '/', ' ' -> Variable.X;
            default -> null;
        });
    }
}