package tegenton.card.parse.dfa.state.t.h.o.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.o.THOSState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THOSEState extends THOSState {
    private static final THOSEState instance = new THOSEState();

    public static THOSEState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from THOSEState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case ' ', '\0' -> Optional.of(Determiner.THOSE);
            default -> Optional.empty();
        };
    }
}
