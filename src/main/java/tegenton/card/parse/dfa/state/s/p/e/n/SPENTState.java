package tegenton.card.parse.dfa.state.s.p.e.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.s.p.e.SPENState;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class SPENTState extends SPENState {
    private static final SPENTState INSTANCE = new SPENTState();

    /**
     * @return Singleton instance.
     */
    public static SPENTState state() {
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
            case '\0', ' ' -> Morpheme.ED;
            default -> null;
        });
    }
}
