package tegenton.card.parse.dfa.state.i;

import tegenton.card.parse.dfa.state.IState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.n.INGState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class INState extends IState {
    private static final INState instance = new INState();

    public static INState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'D' -> new StateSequence("DESTRUCTIBLE", Keyword.INDESTRUCTIBLE);
            case 'G' -> INGState.state();
            default -> throw new IllegalStateException("Cannot transition from INState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Preposition.IN);
            default -> Optional.empty();
        };
    }
}
