package tegenton.card.parse.dfa.state.d.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.d.DIState;
import tegenton.card.parse.dfa.state.e.EDState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class DIEState extends DIState {
    private static final DIEState INSTANCE = new DIEState();

    public static DIEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
            case 'S' -> this;
            case ',', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'D', ',', '\0', ' ' -> ObjectVerb.DIE;
            default -> null;
        });
    }
}
