package tegenton.card.parse.dfa.state.t.h.e.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.e.THESState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THESEState extends THESState {
    private static final THESEState instance = new THESEState();

    public static THESEState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from THESEState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case ' ', '\0' -> Optional.of(Determiner.THESE);
            default -> Optional.empty();
        };
    }
}
