package tegenton.card.parse.dfa.state.n.a.m;

import tegenton.card.parse.dfa.state.NState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.e.EDState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectAttribute;

import java.util.Optional;

public class NAMEState extends NState {
    private static final NAMEState INSTANCE = new NAMEState();

    public static NAMEState state() {
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
            case 'D', '\0', ' ' -> ObjectAttribute.NAME;
            default -> null;
        });
    }
}
