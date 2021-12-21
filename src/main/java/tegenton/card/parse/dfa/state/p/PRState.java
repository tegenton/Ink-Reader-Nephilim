package tegenton.card.parse.dfa.state.p;

import tegenton.card.parse.dfa.state.PState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.p.r.PROState;
import tegenton.card.parse.dfa.state.p.r.e.v.e.n.PREVENTState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class PRState extends PState {
    private static final PRState INSTANCE = new PRState();

    public static PRState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> new InfixSubstring("EVEN", 'T', PREVENTState::state);
            case 'O' -> PROState.state();
            default -> throw new IllegalStateException(
                    "Cannot transition from PRState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
