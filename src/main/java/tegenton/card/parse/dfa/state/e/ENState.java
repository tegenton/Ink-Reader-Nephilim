package tegenton.card.parse.dfa.state.e;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.n.ENCState;
import tegenton.card.parse.dfa.state.e.n.ENDState;
import tegenton.card.parse.dfa.state.e.n.ENTState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ENState extends EState {
    private static final ENState INSTANCE = new ENState();

    public static ENState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'C' -> ENCState.state();
            case 'D' -> ENDState.state();
            case 'T' -> ENTState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
