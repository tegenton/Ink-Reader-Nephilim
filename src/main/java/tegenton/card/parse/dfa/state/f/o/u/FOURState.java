package tegenton.card.parse.dfa.state.f.o.u;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.o.FOUState;
import tegenton.card.parse.dfa.state.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FOURState extends FOUState {
    private static final FOURState instance = new FOURState();

    public static FOURState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.FOUR);
            default -> throw new IllegalStateException("Cannot transition from FOURState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(EnglishNumber.FOUR);
            default -> Optional.empty();
        };
    }
}
