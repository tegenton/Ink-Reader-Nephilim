package tegenton.card.parse.dfa.state.f.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.FIState;
import tegenton.card.parse.dfa.state.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FIFState extends FIState {
    private static final FIFState INSTANCE = new FIFState();

    public static FIFState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.FIVE);
            default -> throw new IllegalStateException("Cannot transition from FIFState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
