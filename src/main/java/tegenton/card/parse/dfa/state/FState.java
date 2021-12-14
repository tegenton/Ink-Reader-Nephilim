package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.f.FIState;
import tegenton.card.parse.dfa.state.f.FLState;
import tegenton.card.parse.dfa.state.f.FOState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FState extends State {
    private static final FState INSTANCE = new FState();

    public static FState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> new StateSequence("EAR", Keyword.FEAR);
            case 'I' -> FIState.state();
            case 'L' -> FLState.state();
            case 'O' -> FOState.state();
            case 'R' -> new StateSequence("ROM", Preposition.FROM);
            default -> throw new IllegalStateException("Cannot transition from FState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
