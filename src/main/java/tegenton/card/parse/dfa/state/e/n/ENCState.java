package tegenton.card.parse.dfa.state.e.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.ENState;
import tegenton.card.parse.dfa.state.e.n.c.h.a.n.ENCHANTState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ENCState extends ENState {
    private static final ENCState INSTANCE = new ENCState();

    /**
     * @return Singleton instance.
     */
    public static ENCState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'H' -> new InfixSubstring("HAN", 'T', ENCHANTState::state);
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
