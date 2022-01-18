package tegenton.card.parse.dfa.state.e.n.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.n.ENTState;
import tegenton.card.parse.dfa.state.e.n.t.e.ENTERState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ENTEState extends ENTState {
    private static final ENTEState INSTANCE = new ENTEState();

    public static ENTEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> ENTERState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
