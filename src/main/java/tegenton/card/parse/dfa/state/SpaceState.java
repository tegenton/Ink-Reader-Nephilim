package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Punctuation;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class SpaceState extends State {
    private static final SpaceState instance = new SpaceState();

    public static SpaceState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return EmptyState.state().transition(c);
    }

    @Override
    public Optional<Punctuation> produce(char c) {
        return Optional.of(Punctuation.SPACE);
    }
}
