package tegenton.card.parse.dfa.state.d;

import tegenton.card.parse.dfa.state.DState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.e.DECState;
import tegenton.card.parse.dfa.state.d.e.a.DEALState;
import tegenton.card.parse.dfa.state.d.e.f.e.n.DEFENDState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class DEState extends DState {
    private static final DEState INSTANCE = new DEState();

    /**
     * @return Singleton instance.
     */
    public static DEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new InfixSubstring("A", 'L', DEALState::state);
            case 'C' -> DECState.state();
            case 'F' -> new InfixSubstring("FEN", 'D', DEFENDState::state);
            case 'S' -> new SuffixSubstring("STROY", PlayerVerb.DESTROY);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
