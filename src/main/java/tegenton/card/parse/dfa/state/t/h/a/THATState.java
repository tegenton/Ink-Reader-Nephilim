package tegenton.card.parse.dfa.state.t.h.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THAState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THATState extends THAState {
    private static final THATState instance = new THATState();

    public static THATState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from THATState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case ' ', '\0' -> Optional.of(Determiner.THAT);
            default -> Optional.empty();
        };
    }
}
