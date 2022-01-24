package tegenton.card.parse.dfa.state.f.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.FIState;
import tegenton.card.parse.dfa.substring.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.value.EnglishNumber;

import java.util.Optional;

public class FIFState extends FIState {
    private static final FIFState INSTANCE = new FIFState();

    /**
     * @return Singleton instance.
     */
    public static FIFState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.FIVE);
            default -> throw new IllegalStateException(
                    "Cannot transition from FIFState on " + c);
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
