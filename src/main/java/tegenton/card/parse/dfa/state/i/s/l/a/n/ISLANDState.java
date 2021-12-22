package tegenton.card.parse.dfa.state.i.s.l.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.WState;
import tegenton.card.parse.dfa.state.i.ISState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.LandType;

import java.util.Optional;

public class ISLANDState extends ISState {
    private static final ISLANDState INSTANCE = new ISLANDState();

    public static ISLANDState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'W' -> WState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'W', '\0', ' ' -> LandType.ISLAND;
            default -> null;
        });
    }
}
