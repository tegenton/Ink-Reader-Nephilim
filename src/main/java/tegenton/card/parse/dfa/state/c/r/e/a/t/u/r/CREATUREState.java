package tegenton.card.parse.dfa.state.c.r.e.a.t.u.r;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.c.r.e.a.CREATState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class CREATUREState extends CREATState {
    private static final CREATUREState INSTANCE = new CREATUREState();

    public static CREATUREState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '.', '\n', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '.', '\n', '\0', ' ' -> CardType.CREATURE;
            default -> null;
        });
    }
}
