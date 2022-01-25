package tegenton.card.lexer.dfa.state.i;

import tegenton.card.lexer.dfa.state.IState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class IFState extends IState {
    private static final IFState INSTANCE = new IFState();

    /**
     * @return Singleton instance.
     */
    public static IFState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
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
            case '\0', ' ' -> SubordinateConjunction.IF;
            default -> null;
        });
    }
}
