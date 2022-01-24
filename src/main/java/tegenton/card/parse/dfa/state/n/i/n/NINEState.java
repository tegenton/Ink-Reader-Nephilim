package tegenton.card.parse.dfa.state.n.i.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.n.i.NINState;
import tegenton.card.parse.dfa.substring.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.value.EnglishNumber;

import java.util.Optional;

public class NINEState extends NINState {
    private static final NINEState INSTANCE = new NINEState();

    /**
     * @return Singleton instance.
     */
    public static NINEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.NINE);
            default -> throw new IllegalStateException(
                    "Cannot transition from NINEState on " + c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        if (c == '\0' || c == ' ') {
            return Optional.of(EnglishNumber.NINE);
        }
        return Optional.empty();
    }
}
