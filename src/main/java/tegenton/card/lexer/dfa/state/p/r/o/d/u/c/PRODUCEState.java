package tegenton.card.lexer.dfa.state.p.r.o.d.u.c;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.e.EDState;
import tegenton.card.lexer.dfa.state.p.r.PROState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.SourceVerb;

import java.util.Optional;

public class PRODUCEState extends PROState {
    private static final PRODUCEState INSTANCE = new PRODUCEState();

    /**
     * @return Singleton instance.
     */
    public static PRODUCEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
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
            case 'D', '\0', ' ' -> SourceVerb.PRODUCE;
            default -> null;
        });
    }
}
