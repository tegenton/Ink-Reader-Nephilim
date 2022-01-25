package tegenton.card.lexer.dfa.state.r.e.s.o.l.v;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.r.e.s.o.l.RESOLVState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.SourceVerb;

import java.util.Optional;

public class RESOLVEState extends RESOLVState {
    private static final RESOLVEState INSTANCE = new RESOLVEState();

    /**
     * @return Singleton instance.
     */
    public static RESOLVEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> this;
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
            case '\0', ' ' -> SourceVerb.RESOLVE;
            default -> null;
        });
    }
}
