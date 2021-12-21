package tegenton.card.parse.dfa.state.m.o.u.n.t.a.i;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.MOState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.LandType;

import java.util.Optional;

public class MOUNTAINState extends MOState {
    private static final MOUNTAINState INSTANCE = new MOUNTAINState();

    public static MOUNTAINState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> SState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> LandType.MOUNTAIN;
            default -> null;
        });
    }
}
