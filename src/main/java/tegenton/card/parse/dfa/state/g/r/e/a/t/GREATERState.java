package tegenton.card.parse.dfa.state.g.r.e.a.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Comparative;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class GREATERState extends State {
    private static final GREATERState instance = new GREATERState();

    public static GREATERState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from GREATERState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Comparative.GREATER);
            default -> Optional.empty();
        };
    }
}
