package tegenton.card.lexer.dfa.state.n.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.n.NOState;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class NOTState extends NOState {
    private static final NOTState INSTANCE = new NOTState();

    /**
     * @return Singleton instance.
     */
    public static NOTState state() {
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
            case '\0', ' ' -> Adverb.NOT;
            default -> null;
        });
    }
}
