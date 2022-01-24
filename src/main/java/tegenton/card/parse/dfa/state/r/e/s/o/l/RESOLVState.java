package tegenton.card.parse.dfa.state.r.e.s.o.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.r.e.RESState;
import tegenton.card.parse.dfa.state.r.e.s.o.l.v.RESOLVEState;
import tegenton.card.parse.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.SourceVerb;

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
