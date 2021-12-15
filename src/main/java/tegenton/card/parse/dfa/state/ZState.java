package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.z.ZEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ZState extends State {
    private static final ZState instance = new ZState();

    public static ZState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> ZEState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
