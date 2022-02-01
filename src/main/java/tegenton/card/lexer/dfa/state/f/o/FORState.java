package tegenton.card.lexer.dfa.state.f.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.f.FOState;
import tegenton.card.lexer.dfa.state.f.o.r.e.s.FORESTState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class FORState extends FOState {
    private static final FORState INSTANCE = new FORState();

    /**
     * @return Singleton instance.
     */
    public static FOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new InfixSubstring("ES", 'T', FORESTState::state);
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
            case '\0', ' ' -> Preposition.FOR;
            default -> null;
        });
    }
}