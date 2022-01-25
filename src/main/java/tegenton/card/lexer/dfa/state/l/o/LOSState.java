package tegenton.card.lexer.dfa.state.l.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.l.LOState;
import tegenton.card.lexer.dfa.state.l.o.s.LOSEState;
import tegenton.card.lexer.dfa.state.l.o.s.LOSTState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.TargetVerb;

import java.util.Optional;

public class LOSState extends LOState {
    private static final LOSState INSTANCE = new LOSState();

    /**
     * @return Singleton instance.
     */
    public static LOSState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> LOSEState.state();
            case 'T' -> LOSTState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'T' -> TargetVerb.LOSE;
            default -> null;
        });
    }
}
