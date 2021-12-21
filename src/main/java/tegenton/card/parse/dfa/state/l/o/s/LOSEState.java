package tegenton.card.parse.dfa.state.l.o.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.l.LOState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class LOSEState extends LOState {
    private static final LOSEState INSTANCE = new LOSEState();

    public static LOSEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> PlayerVerb.LOSE;
            default -> null;
        });
    }
}
