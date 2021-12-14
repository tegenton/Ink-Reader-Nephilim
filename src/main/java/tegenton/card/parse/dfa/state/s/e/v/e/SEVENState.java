package tegenton.card.parse.dfa.state.s.e.v.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.morpheme.TEENMorpheme;
import tegenton.card.parse.dfa.state.s.e.v.SEVEState;
import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class SEVENState extends SEVEState {
    private static final SEVENState INSTANCE = new SEVENState();

    public static SEVENState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.SEVEN);
            default -> throw new IllegalStateException("Cannot transition from SEVENState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(EnglishNumber.SEVEN);
            default -> Optional.empty();
        };
    }
}
