package tegenton.card.lexer.dfa.state.g.r.e.a.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.g.r.e.a.GREATState;
import tegenton.card.lexer.dfa.state.g.r.e.a.t.e.GREATERState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class GREATEState extends GREATState {
    private static final GREATEState INSTANCE = new GREATEState();

    /**
     * @return Singleton instance.
     */
    public static GREATEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> GREATERState.state();
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
