package tegenton.card.lexer.dfa.state.n.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.n.NEState;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class NEWState extends NEState {
    private static final NEWState INSTANCE = new NEWState();

    /**
     * @return Singleton instance.
     */
    public static NEWState state() {
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
            case '\0', ' ' -> Adjective.NEW;
            default -> null;
        });
    }
}