package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.g.GRState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class GState extends State {
    private static final GState INSTANCE = new GState();

    public static GState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> GRState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
