package tegenton.card.parse.dfa.state.g;

import tegenton.card.parse.dfa.state.GState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.r.GREState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.Zone;
import java.util.Optional;

public class GRState extends GState {
    private static final GRState INSTANCE = new GRState();

    public static GRState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("AVEYARD", Zone.GRAVEYARD);
            case 'E' -> GREState.state();
            default -> throw new IllegalStateException(
                    "Cannot transition from GRState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
