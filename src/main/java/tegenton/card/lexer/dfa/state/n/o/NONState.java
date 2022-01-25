package tegenton.card.lexer.dfa.state.n.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.BState;
import tegenton.card.lexer.dfa.state.TState;
import tegenton.card.lexer.dfa.state.n.NOState;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class NONState extends NOState {
    private static final NONState INSTANCE = new NONState();

    /**
     * @return Singleton instance.
     */
    public static NONState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> AState.state();
            case 'B' -> BState.state();
            case 'T' -> TState.state();
            case '-', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'A', 'B', 'T', '-', '\0', ' ' -> Adverb.NOT;
            default -> null;
        });
    }
}
