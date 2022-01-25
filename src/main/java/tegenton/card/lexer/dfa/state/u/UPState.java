package tegenton.card.lexer.dfa.state.u;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.UState;
import tegenton.card.lexer.dfa.state.u.p.k.e.e.UPKEEPState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class UPState extends UState {
    private static final UPState INSTANCE = new UPState();

    /**
     * @return Singleton instance.
     */
    public static UPState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'K' -> new InfixSubstring("KEE", 'P', UPKEEPState::state);
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> Particle.UP;
            default -> null;
        });
    }
}
