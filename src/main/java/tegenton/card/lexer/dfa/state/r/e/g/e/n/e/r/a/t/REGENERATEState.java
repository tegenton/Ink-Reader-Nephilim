package tegenton.card.lexer.dfa.state.r.e.g.e.n.e.r.a.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.e.EDState;
import tegenton.card.lexer.dfa.state.r.REState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class REGENERATEState extends REState {
    private static final REGENERATEState INSTANCE = new REGENERATEState();

    /**
     * @return Singleton instance.
     */
    public static REGENERATEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
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
            case 'D', '\0', ' ' -> PlayerVerb.REGENERATE;
            default -> null;
        });
    }
}
