package tegenton.card.parse.dfa.state.u;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.UState;
import tegenton.card.parse.dfa.state.u.p.k.e.e.UPKEEPState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Particle;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class UPState extends UState {
    private static final UPState INSTANCE = new UPState();

    public static UPState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'K' -> new InfixSubstring("KEE", 'P', UPKEEPState::state);
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> Particle.UP;
            default -> null;
        });
    }
}
