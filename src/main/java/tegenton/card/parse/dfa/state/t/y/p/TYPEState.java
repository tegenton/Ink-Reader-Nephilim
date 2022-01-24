package tegenton.card.parse.dfa.state.t.y.p;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;

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
