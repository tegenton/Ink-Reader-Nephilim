package tegenton.card.parse.dfa.state.a.u.r;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.EnchantmentType;

import java.util.Optional;

public class AURAState extends AState {
    private static final AURAState INSTANCE = new AURAState();

    public static AURAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\0', ' ' -> EnchantmentType.AURA;
            default -> null;
        });
    }
}
