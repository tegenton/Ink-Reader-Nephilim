package tegenton.card.lexer.dfa.state.t.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.TEState;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class TENState extends TEState {
    private static final TENState INSTANCE = new TENState();

    /**
     * @return Singleton instance.
     */
    public static TENState state() {
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
            case '\0', ' ' -> EnglishNumber.TEN;
            default -> null;
        });
    }
}
