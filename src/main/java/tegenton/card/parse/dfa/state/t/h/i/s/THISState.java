package tegenton.card.parse.dfa.state.t.h.i.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.i.THIState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THISState extends THIState {
    private static final THISState instance = new THISState();

    public static THISState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from THISState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        if (c == '\0' || c == ' ') {
            return Optional.of(Determiner.THIS);
        }
        return Optional.empty();
    }
}
