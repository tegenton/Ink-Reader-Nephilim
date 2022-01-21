package tegenton.card.parse.dfa.state.e.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.ENState;
import tegenton.card.parse.dfa.state.e.n.t.ENTEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ENTState extends ENState {
    private static final ENTState INSTANCE = new ENTState();

    public static ENTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> ENTEState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
