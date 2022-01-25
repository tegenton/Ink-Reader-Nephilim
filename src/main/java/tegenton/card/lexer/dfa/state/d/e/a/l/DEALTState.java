package tegenton.card.lexer.dfa.state.d.e.a.l;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.d.DEState;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class DEALTState extends DEState {
    private static final DEALTState INSTANCE = new DEALTState();

    /**
     * @return Singleton instance.
     */
    public static DEALTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case ',', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case ',', '\0', ' ' -> Morpheme.ED;
            default -> null;
        });
    }
}
