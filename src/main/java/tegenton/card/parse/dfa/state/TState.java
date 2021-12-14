package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.t.*;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TState extends State {
    private static final TState INSTANCE = new TState();

    public static TState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> TAState.state();
            case 'E' -> TEState.state();
            case 'H' -> THState.state();
            case 'O' -> TOState.state();
            case 'R' -> new StateSequence("RAMPLE", Keyword.TRAMPLE);
            case 'W' -> TWState.state();
            default -> throw new IllegalStateException("Cannot transition from TState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
