package tegenton.card.lexer.dfa.state.a.n.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.n.ANTState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Zone;

import java.util.Optional;

public class ANTEState extends ANTState {
    private static final ANTEState INSTANCE = new ANTEState();

    /**
     * @return Singleton instance.
     */
    public static ANTEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> this;
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> Zone.ANTE;
            default -> null;
        });
    }
}
