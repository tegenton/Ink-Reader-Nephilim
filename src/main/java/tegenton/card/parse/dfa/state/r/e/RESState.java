package tegenton.card.parse.dfa.state.r.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.r.REState;
import tegenton.card.parse.dfa.state.r.e.s.RESTState;
import tegenton.card.parse.dfa.state.r.e.s.o.l.RESOLVState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class RESState extends REState {
    private static final RESState INSTANCE = new RESState();

    public static RESState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'O' -> new InfixSubstring("OL", 'V', RESOLVState::state);
            case 'T' -> RESTState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
