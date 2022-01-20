package tegenton.card.parse.dfa.state.c.o.n.t.r.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.c.o.n.t.r.CONTROState;
import tegenton.card.parse.dfa.state.c.o.n.t.r.o.l.CONTROLLState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class CONTROLState extends CONTROState {
    private static final CONTROLState INSTANCE = new CONTROLState();

    public static CONTROLState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> CONTROLLState.state();
            case 'S' -> this;
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'L', ',', '\0', '.', ' ' -> PlayerVerb.CONTROL;
            default -> null;
        });
    }
}
