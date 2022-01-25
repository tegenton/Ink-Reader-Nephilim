package tegenton.card.lexer.dfa.state.s.p.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.s.p.SPEState;
import tegenton.card.lexer.dfa.state.s.p.e.n.SPENDState;
import tegenton.card.lexer.dfa.state.s.p.e.n.SPENTState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class SPENState extends SPEState {
    private static final SPENState INSTANCE = new SPENState();

    /**
     * @return Singleton instance.
     */
    public static SPENState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> SPENDState.state();
            case 'T' -> SPENTState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'T' -> PlayerVerb.SPEND;
            default -> null;
        });
    }
}
