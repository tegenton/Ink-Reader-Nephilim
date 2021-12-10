package tegenton.card.parse.dfa.state.t.a.r.g.e;

import tegenton.card.parse.dfa.state.SpaceState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TARGETState extends State {
    private static final TARGETState instance = new TARGETState();

    public static TARGETState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from EmptyState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Determiner.TARGET);
            default -> Optional.empty();
        };
    }
}
