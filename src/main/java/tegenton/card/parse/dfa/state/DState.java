package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.d.DRState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class DState extends State {
    private static final DState INSTANCE = new DState();

    public static DState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> new StateSequence("EFENDER", Keyword.DEFENDER);
            case 'R' -> DRState.state();
            default -> throw new IllegalStateException("Cannot transition from DState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
