package tegenton.card.parse.dfa.state.o;

import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class OFState extends OState {
    private static final OFState INSTANCE = new OFState();

    public static OFState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from OState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        if (c == '\0' || c == ' ') {
            return Optional.of(Preposition.OF);
        }
        return Optional.empty();
    }
}
