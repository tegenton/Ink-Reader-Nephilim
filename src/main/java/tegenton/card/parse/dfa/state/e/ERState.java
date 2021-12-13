package tegenton.card.parse.dfa.state.e;

import tegenton.card.parse.dfa.state.SpaceState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ERState extends State {
    private static final ERState instance = new ERState();

    public static ERState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from ERState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Morpheme.ER);
            default -> Optional.empty();
        };
    }
}
