package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.c.CAState;
import tegenton.card.parse.dfa.state.c.CHState;
import tegenton.card.parse.dfa.state.c.COState;
import tegenton.card.parse.dfa.state.c.CRState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Color;

import java.util.Optional;

public class CState extends State {
    private static final CState INSTANCE = new CState();

    public static CState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> CAState.state();
            case 'H' -> CHState.state();
            case 'O' -> COState.state();
            case 'R' -> CRState.state();
            case '}', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '}', '\0', ' ' -> Color.C;
            default -> null;
        });
    }
}
