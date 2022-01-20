package tegenton.card.parse.dfa.state.d.i.v.i.d;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.d.DIState;
import tegenton.card.parse.dfa.state.e.EDState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class DIVIDEState extends DIState {
    private static final DIVIDEState INSTANCE = new DIVIDEState();

    public static DIVIDEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'D' -> EDState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'D', '\0', ' ' -> PlayerVerb.DIVIDE;
            default -> null;
        });
    }
}
