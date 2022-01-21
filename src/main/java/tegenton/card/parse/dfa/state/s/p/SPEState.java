package tegenton.card.parse.dfa.state.s.p;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.SPState;
import tegenton.card.parse.dfa.state.s.p.e.SPELState;
import tegenton.card.parse.dfa.state.s.p.e.SPENState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class SPEState extends SPState {
    private static final SPEState INSTANCE = new SPEState();

    public static SPEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> SPELState.state();
            case 'N' -> SPENState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
