package tegenton.card.parse.dfa.state.t.w.e.n.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.w.e.n.TWENTState;
import tegenton.card.parse.lexicon.value.EnglishNumber;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class TWENTYState extends TWENTState {
    private static final TWENTYState INSTANCE = new TWENTYState();

    public static TWENTYState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        switch (c) {
            default -> throw new IllegalStateException(
                    "Cannot transition from TWENTYState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case '\0', '0' -> Optional.of(EnglishNumber.TWENTY);
            default -> Optional.empty();
        };
    }
}
