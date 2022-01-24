package tegenton.card.parse.dfa.state.g;

import tegenton.card.parse.dfa.state.GState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.r.GREState;
import tegenton.card.parse.dfa.state.g.r.a.v.e.y.a.r.GRAVEYARDState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class GRState extends GState {
    private static final GRState INSTANCE = new GRState();

    /**
     * @return Singleton instance.
     */
    public static GRState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new InfixSubstring("AVEYAR",
                    'D',
                    GRAVEYARDState::state);
            case 'E' -> GREState.state();
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
