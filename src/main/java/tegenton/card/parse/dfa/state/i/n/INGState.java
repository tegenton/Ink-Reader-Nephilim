package tegenton.card.parse.dfa.state.i.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.i.INState;
import tegenton.card.parse.lexicon.Morpheme;
import java.util.Optional;

public class INGState extends INState {
    private static final INGState INSTANCE = new INGState();

    public static INGState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<Morpheme> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Morpheme.ING);
            default -> Optional.empty();
        };
    }
}
