package tegenton.card.parse.dfa.state.s.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.SIState;
import tegenton.card.parse.dfa.substring.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.value.EnglishNumber;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class SIXState extends SIState {
    private static final SIXState INSTANCE = new SIXState();

    /**
     * @return Singleton instance.
     */
    public static SIXState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.SIX);
            default -> throw new IllegalStateException(
                    "Cannot transition from SIXState on " + c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case '\0', ' ', '.' -> Optional.of(EnglishNumber.SIX);
            default -> Optional.empty();
        };
    }
}
