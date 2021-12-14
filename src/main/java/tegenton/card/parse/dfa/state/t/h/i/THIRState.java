package tegenton.card.parse.dfa.state.t.h.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THIRState extends State {
    private static final THIRState INSTANCE = new THIRState();

    public static THIRState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.THREE);
            default -> throw new IllegalStateException("Cannot transition from THIRState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
