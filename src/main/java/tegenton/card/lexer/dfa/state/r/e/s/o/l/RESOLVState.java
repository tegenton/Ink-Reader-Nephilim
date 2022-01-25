package tegenton.card.lexer.dfa.state.r.e.s.o.l;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.r.e.RESState;
import tegenton.card.lexer.dfa.state.r.e.s.o.l.v.RESOLVEState;
import tegenton.card.lexer.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.SourceVerb;

import java.util.Optional;

public class RESOLVState extends RESState {
    private static final RESOLVState INSTANCE = new RESOLVState();

    /**
     * @return Singleton instance.
     */
    public static RESOLVState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> RESOLVEState.state();
            case 'I' -> new INGMorpheme();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'I' -> SourceVerb.RESOLVE;
            default -> null;
        });
    }
}
