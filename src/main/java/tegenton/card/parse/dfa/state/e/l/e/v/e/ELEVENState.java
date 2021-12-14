package tegenton.card.parse.dfa.state.e.l.e.v.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.l.e.v.ELEVEState;
import tegenton.card.parse.lexicon.EnglishNumber;
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
            default -> throw new IllegalStateException("Cannot transition from ELEVENState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        if (c == '\0' || c == '0') {
            return Optional.of(EnglishNumber.ELEVEN);
        }
        return Optional.empty();
    }
}
