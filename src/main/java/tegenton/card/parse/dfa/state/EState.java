package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.e.*;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class EState extends State {
    private static final EState INSTANCE = new EState();

    public static EState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> EAState.state();
            case 'I' -> EIState.state();
            case 'L' -> ELState.state();
            case 'N' -> ENState.state();
            case 'R' -> ERState.state();
            case 'X' -> EXState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}