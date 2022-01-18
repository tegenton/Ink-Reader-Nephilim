package tegenton.card.parse.dfa.state.s.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.STState;
import tegenton.card.parse.dfa.state.s.t.e.STEPState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class STEState extends STState {
    private static final STEState INSTANCE = new STEState();

    public static STEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'P' -> STEPState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
