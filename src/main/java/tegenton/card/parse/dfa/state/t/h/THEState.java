package tegenton.card.parse.dfa.state.t.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.THState;
import tegenton.card.parse.dfa.state.t.h.e.THENState;
import tegenton.card.parse.dfa.state.t.h.e.THESState;
import tegenton.card.parse.dfa.state.t.h.e.THEYState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THEState extends THState {
    private static final THEState INSTANCE = new THEState();

    public static THEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> THENState.state();
            case 'S' -> THESState.state();
            case 'Y' -> THEYState.state();
            default -> throw new IllegalStateException("Cannot transition from THEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case ' ', '\0' -> Optional.of(Determiner.THE);
            default -> Optional.empty();
        };
    }
}
