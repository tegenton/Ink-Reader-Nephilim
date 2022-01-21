package tegenton.card.parse.dfa.state.z.o.m.b.i;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.ZState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CreatureType;

import java.util.Optional;

public class ZOMBIEState extends ZState {
    private static final ZOMBIEState INSTANCE = new ZOMBIEState();

    public static ZOMBIEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\0', ' ' -> CreatureType.ZOMBIE;
            default -> null;
        });
    }
}
