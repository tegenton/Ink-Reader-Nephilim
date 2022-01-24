package tegenton.card.parse.dfa.state.b.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.b.BAState;
import tegenton.card.parse.dfa.state.b.a.n.BANDState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class BANState extends BAState {
    private static final BANState INSTANCE = new BANState();

    /**
     * @return Singleton instance.
     */
    public static BANState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> BANDState.state();
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
