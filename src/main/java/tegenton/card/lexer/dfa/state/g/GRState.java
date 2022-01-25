package tegenton.card.lexer.dfa.state.g;

import tegenton.card.lexer.dfa.state.GState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.g.r.GREState;
import tegenton.card.lexer.dfa.state.g.r.a.v.e.y.a.r.GRAVEYARDState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;

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
