package tegenton.card.parse.dfa.state.o.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.o.ONState;
import tegenton.card.parse.lexicon.value.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ONEState extends ONState {
    private static final ONEState INSTANCE = new ONEState();

    public static ONEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
            default -> throw new IllegalStateException(
                    "Cannot transition from AState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(EnglishNumber.ONE);
            default -> Optional.empty();
        };
    }
}
