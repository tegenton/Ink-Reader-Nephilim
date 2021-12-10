package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

class EmptyState extends State {
    private static final EmptyState instance = new EmptyState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> AState.state();
            case 'D' -> DState.state();
            case 'F' -> FState.state();
            case 'O' -> OState.state();
            case 'W' -> WState.state();
            case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' -> NumberState.state(c);
            case '.' -> PeriodState.state();
            case '\0' -> EmptyState.state();
            default -> throw new IllegalStateException("Cannot transition from EmptyState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return Optional.empty();
    }
}
