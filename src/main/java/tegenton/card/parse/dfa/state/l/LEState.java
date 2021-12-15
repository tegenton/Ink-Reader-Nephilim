package tegenton.card.parse.dfa.state.l;

import tegenton.card.parse.dfa.state.LState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.e.LESState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.something.object.ObjectVerb;
import java.util.Optional;

public class LEState extends LState {
    private static final LEState INSTANCE = new LEState();

    public static LEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new StateSequence("AVE", ObjectVerb.LEAVE);
            case 'S' -> LESState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}