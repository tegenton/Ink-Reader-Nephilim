package tegenton.card.lexer.dfa.state.w.a.l;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.w.a.WALState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.CreatureType;

import java.util.Optional;

public class WALLState extends WALState {
    private static final WALLState INSTANCE = new WALLState();

    /**
     * @return Singleton instance.
     */
    public static WALLState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\n', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\n', '\0', '.', ' ' -> CreatureType.WALL;
            default -> null;
        });
    }
}
