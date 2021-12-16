package tegenton.card.parse.dfa.state.e.l.e.v.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.l.e.v.ELEVEState;
import tegenton.card.parse.lexicon.value.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ELEVENState extends ELEVEState {
    private static final ELEVENState INSTANCE = new ELEVENState();

    public static ELEVENState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException(
                    "Cannot transition from ELEVENState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', '0' -> Optional.of(EnglishNumber.ELEVEN);
            default -> Optional.empty();
        };
    }
}
