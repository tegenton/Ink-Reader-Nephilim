package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.m.AMOState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class AMState extends AState {
    private static final AMState INSTANCE = new AMState();

    public static AMState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'O' -> AMOState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
