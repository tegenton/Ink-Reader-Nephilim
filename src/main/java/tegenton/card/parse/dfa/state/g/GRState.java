package tegenton.card.parse.dfa.state.g;

import tegenton.card.parse.dfa.state.GState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.r.GREState;
import tegenton.card.parse.dfa.state.g.r.a.v.e.y.a.r.GRAVEYARDState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class GRState extends GState {
    private static final GRState INSTANCE = new GRState();

    public static GRState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new InfixSubstring("AVEYAR", 'D', GRAVEYARDState::state);
            case 'E' -> GREState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
