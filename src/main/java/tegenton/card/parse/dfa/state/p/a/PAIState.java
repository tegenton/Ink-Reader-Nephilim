package tegenton.card.parse.dfa.state.p.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.p.PAState;
import tegenton.card.parse.dfa.state.p.a.i.PAIDState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

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
