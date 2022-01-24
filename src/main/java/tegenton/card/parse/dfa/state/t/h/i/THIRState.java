package tegenton.card.parse.dfa.state.t.h.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THIState;
import tegenton.card.parse.dfa.substring.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.value.EnglishNumber;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THIRState extends THIState {
    private static final THIRState INSTANCE = new THIRState();

    /**
     * @return Singleton instance.
     */
    public static THIRState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.THREE);
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
