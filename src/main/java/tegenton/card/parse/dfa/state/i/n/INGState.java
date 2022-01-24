package tegenton.card.parse.dfa.state.i.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.i.INState;
import tegenton.card.parse.lexicon.Morpheme;

import java.util.Optional;

public class INGState extends INState {
    private static final INGState INSTANCE = new INGState();

    /**
     * @return Singleton instance.
     */
    public static INGState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Morpheme> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Morpheme.ING);
            default -> Optional.empty();
        };
    }
}
