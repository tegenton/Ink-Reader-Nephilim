package tegenton.card.lexer.dfa.state.a.c.t.i.v.a.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.c.t.i.ACTIVState;
import tegenton.card.lexer.dfa.state.e.EDState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class ACTIVATEState extends ACTIVState {
    private static final ACTIVATEState INSTANCE = new ACTIVATEState();

    /**
     * @return Singleton instance.
     */
    public static ACTIVATEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
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
            case 'D', '\0', '.', ' ' -> PlayerVerb.ACTIVATE;
            default -> null;
        });
    }
}
