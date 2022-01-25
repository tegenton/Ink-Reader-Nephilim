package tegenton.card.lexer.dfa.state.a.t.t.a.c.k.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.a.t.t.a.c.k.ATTACKEState;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ATTACKERState extends ATTACKEState {
    private static final ATTACKERState INSTANCE = new ATTACKERState();

    /**
     * @return Singleton instance.
     */
    public static ATTACKERState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
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
            case '\0', ' ' -> Morpheme.ER;
            default -> null;
        });
    }
}
