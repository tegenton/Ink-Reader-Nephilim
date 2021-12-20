package tegenton.card.parse.dfa.state.w;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.WState;
import tegenton.card.parse.dfa.state.w.a.WALState;
import tegenton.card.parse.dfa.state.w.a.WAYState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class WAState extends WState {
    private static final WAState INSTANCE = new WAState();

    public static WAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> WALState.state();
            case 'Y' -> WAYState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}