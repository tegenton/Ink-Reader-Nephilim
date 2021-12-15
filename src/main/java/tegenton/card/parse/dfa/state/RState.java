package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.r.REState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class RState extends State {
    private static final RState INSTANCE = new RState();

    public static RState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> REState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
