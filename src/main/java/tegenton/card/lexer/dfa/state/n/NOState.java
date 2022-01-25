package tegenton.card.lexer.dfa.state.n;

import tegenton.card.lexer.dfa.state.NState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.n.o.NONState;
import tegenton.card.lexer.dfa.state.n.o.NOTState;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class NOState extends NState {
    private static final NOState INSTANCE = new NOState();

    /**
     * @return Singleton instance.
     */
    public static NOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> NONState.state();
            case 'T' -> NOTState.state();
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
            case '\0', ' ' -> Determiner.NO;
            default -> null;
        });
    }
}
