package tegenton.card.lexer.dfa.state.a.l;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.ALState;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ALLState extends ALState {
    private static final ALLState INSTANCE = new ALLState();

    /**
     * @return Singleton instance.
     */
    public static ALLState state() {
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
            case '\0', ' ' -> Determiner.ALL;
            default -> null;
        });
    }
}
