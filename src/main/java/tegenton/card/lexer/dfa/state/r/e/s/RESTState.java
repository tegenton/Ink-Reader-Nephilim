package tegenton.card.lexer.dfa.state.r.e.s;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.r.e.RESState;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class RESTState extends RESState {
    private static final RESTState INSTANCE = new RESTState();

    /**
     * @return Singleton instance.
     */
    public static RESTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> Noun.REST;
            default -> null;
        });
    }
}
