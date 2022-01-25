package tegenton.card.lexer.dfa.state.a;

import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.s.s.i.g.ASSIGNState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ASState extends AState {
    private static final ASState INSTANCE = new ASState();

    /**
     * @return Singleton instance.
     */
    public static ASState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> new InfixSubstring("SIG", 'N', ASSIGNState::state);
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
            case '\0', ' ' -> SubordinateConjunction.AS;
            default -> null;
        });
    }
}
