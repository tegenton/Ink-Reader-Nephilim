package tegenton.card.lexer.dfa.state.t.h;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.THState;
import tegenton.card.lexer.dfa.state.t.h.e.THEIState;
import tegenton.card.lexer.dfa.state.t.h.e.THEMState;
import tegenton.card.lexer.dfa.state.t.h.e.THENState;
import tegenton.card.lexer.dfa.state.t.h.e.THESState;
import tegenton.card.lexer.dfa.state.t.h.e.THEYState;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class THEState extends THState {
    private static final THEState INSTANCE = new THEState();

    /**
     * @return Singleton instance.
     */
    public static THEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> THEIState.state();
            case 'M' -> THEMState.state();
            case 'N' -> THENState.state();
            case 'S' -> THESState.state();
            case 'Y' -> THEYState.state();
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case ' ', '\0' -> Determiner.THE;
            default -> null;
        });
    }
}
