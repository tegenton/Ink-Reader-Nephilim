package tegenton.card.parse.dfa.state.c.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.c.CAState;
import tegenton.card.parse.dfa.state.c.a.n.CANtState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetAuxiliaryVerb;

import java.util.Optional;

public class CANState extends CAState {
    private static final CANState INSTANCE = new CANState();

    public static CANState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\u2019' -> CANtState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> TargetAuxiliaryVerb.CAN;
            default -> null;
        });
    }
}
