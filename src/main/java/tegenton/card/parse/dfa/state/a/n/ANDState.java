package tegenton.card.parse.dfa.state.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.ANState;
import tegenton.card.parse.lexicon.Conjunction;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ANDState extends ANState {
    private static final ANDState INSTANCE = new ANDState();

    /**
     * @return Singleton instance.
     */
    public static ANDState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', '/', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '/', ' ' -> Conjunction.AND;
            default -> null;
        });
    }
}
