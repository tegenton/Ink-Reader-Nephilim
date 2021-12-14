package tegenton.card.parse.dfa.state.e.i.g.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.i.g.EIGHState;
import tegenton.card.parse.dfa.substring.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class EIGHTState extends EIGHState {
    private static final EIGHTState INSTANCE = new EIGHTState();

    public static EIGHTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> {
                TEENMorpheme teen = new TEENMorpheme(EnglishNumber.EIGHT);
                teen.transition('E');
                yield teen;
            }
            default -> throw new IllegalStateException("Cannot transition from EIGHTState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(EnglishNumber.EIGHT);
            default -> Optional.empty();
        };
    }
}
