package tegenton.card.lexer.dfa.state.t.y.p;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.TState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;

import java.util.Optional;

public class TYPEState extends TState {
    private static final TYPEState INSTANCE = new TYPEState();

    /**
     * @return Singleton instance.
     */
    public static TYPEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    public Optional<Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\0', '.', ' ' -> GameNoun.TYPE;
            default -> null;
        });
    }
}
