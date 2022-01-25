package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.y.o.YOUState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.Variable;

import java.util.Optional;

public class YState extends tegenton.card.lexer.dfa.state.State {
    private static final YState INSTANCE = new YState();

    /**
     * @return Singleton instance.
     */
    public static YState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'O' -> new InfixSubstring("O", 'U', YOUState::state);
            case ',', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case ',', '\0', ' ' -> Variable.Y;
            default -> null;
        });
    }
}
