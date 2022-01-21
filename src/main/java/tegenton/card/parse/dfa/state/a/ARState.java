package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.r.AREState;
import tegenton.card.parse.dfa.state.a.r.t.i.f.a.c.ARTIFACTState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ARState extends AState {
    private static final ARState INSTANCE = new ARState();

    public static ARState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> AREState.state();
            case 'T' -> new InfixSubstring("TIFAC", 'T', ARTIFACTState::state);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
