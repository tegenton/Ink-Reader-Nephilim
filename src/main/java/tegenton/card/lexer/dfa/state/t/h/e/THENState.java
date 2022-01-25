package tegenton.card.lexer.dfa.state.t.h.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.h.THEState;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class THENState extends THEState {
    private static final THENState INSTANCE = new THENState();

    /**
     * @return Singleton instance.
     */
    public static THENState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
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
            case ',', '\0', ' ' -> Conjunction.THEN;
            default -> null;
        });
    }
}
