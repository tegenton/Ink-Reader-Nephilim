package tegenton.card.parse.dfa.state.a.c.t.i;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.c.t.i.v.ACTIVEState;
import tegenton.card.parse.dfa.state.a.c.t.i.v.a.t.ACTIVATEState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ACTIVState extends AState {
    private static final ACTIVState INSTANCE = new ACTIVState();

    public static ACTIVState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new InfixSubstring("AT", 'E', ACTIVATEState::state);
            case 'E' -> ACTIVEState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
