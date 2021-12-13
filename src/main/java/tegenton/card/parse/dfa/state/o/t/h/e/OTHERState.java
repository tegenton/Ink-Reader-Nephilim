package tegenton.card.parse.dfa.state.o.t.h.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.o.t.h.OTHEState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class OTHERState extends OTHEState {
    private static final OTHERState instance = new OTHERState();

    public static OTHERState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from OTHERState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Determiner.OTHER);
            default -> Optional.empty();
        };
    }
}
