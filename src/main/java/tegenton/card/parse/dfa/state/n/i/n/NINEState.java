package tegenton.card.parse.dfa.state.n.i.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.n.i.NINState;
import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class NINEState extends NINState {
    private static final NINEState INSTANCE = new NINEState();

    public static NINEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from NINEState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        if (c == '\0' || c == ' ') {
            return Optional.of(EnglishNumber.NINE);
        }
        return Optional.empty();
    }
}
