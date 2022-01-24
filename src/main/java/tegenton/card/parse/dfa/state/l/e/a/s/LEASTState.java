package tegenton.card.parse.dfa.state.l.e.a.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.l.e.a.LEASState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class LEASTState extends LEASState {
    private static final LEASTState INSTANCE = new LEASTState();

    /**
     * @return Singleton instance.
     */
    public static LEASTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Determiner.LEAST;
            default -> null;
        });
    }
}
