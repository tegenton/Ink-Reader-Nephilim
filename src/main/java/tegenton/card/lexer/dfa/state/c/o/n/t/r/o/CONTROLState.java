package tegenton.card.lexer.dfa.state.c.o.n.t.r.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.c.o.n.t.r.CONTROState;
import tegenton.card.lexer.dfa.state.c.o.n.t.r.o.l.CONTROLLState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class CONTROLState extends CONTROState {
    private static final CONTROLState INSTANCE = new CONTROLState();

    /**
     * @return Singleton instance.
     */
    public static CONTROLState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> CONTROLLState.state();
            case 'S' -> this;
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
            case 'L', ',', '\0', '.', ' ' -> PlayerVerb.CONTROL;
            default -> null;
        });
    }
}
