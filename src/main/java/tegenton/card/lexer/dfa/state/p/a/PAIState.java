package tegenton.card.lexer.dfa.state.p.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.p.PAState;
import tegenton.card.lexer.dfa.state.p.a.i.PAIDState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class PAIState extends PAState {
    private static final PAIState INSTANCE = new PAIState();

    /**
     * @return Singleton instance.
     */
    public static PAIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> PAIDState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'D' -> PlayerVerb.PAY;
            default -> null;
        });
    }
}
