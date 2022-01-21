package tegenton.card.parse.dfa.state.l;

import tegenton.card.parse.dfa.state.LState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.e.LEAState;
import tegenton.card.parse.dfa.state.l.e.LESState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Particle;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class LEState extends LState {
    private static final LEState INSTANCE = new LEState();

    public static LEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> LEAState.state();
            case 'F' -> new SuffixSubstring("FT", Particle.LEFT);
            case 'S' -> LESState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
