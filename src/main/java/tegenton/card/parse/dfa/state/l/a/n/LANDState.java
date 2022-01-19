package tegenton.card.parse.dfa.state.l.a.n;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.l.LAState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class LANDState extends LAState {
    private static final LANDState INSTANCE = new LANDState();

    public static LANDState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\u2019', '\n', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\u2019', '\n', '\0', '.', ' ' -> CardType.LAND;
            default -> null;
        });
    }
}
