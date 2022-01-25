package tegenton.card.lexer.dfa.state.t.u.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.TState;
import tegenton.card.lexer.dfa.substring.morpheme.EDMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;

import java.util.Optional;

public class TURNState extends TState {
    private static final TURNState INSTANCE = new TURNState();

    /**
     * @return Singleton instance.
     */
    public static TURNState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new EDMorpheme();
            case 'S' -> SState.state();
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'E', 'S', ',', '\0', '.', ' ' -> GameNoun.TURN;
            default -> null;
        });
    }
}
