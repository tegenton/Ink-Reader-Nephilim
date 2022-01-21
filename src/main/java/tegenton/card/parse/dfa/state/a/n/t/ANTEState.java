package tegenton.card.parse.dfa.state.a.n.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.n.ANTState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Zone;

import java.util.Optional;

public class ANTEState extends ANTState {
    private static final ANTEState INSTANCE = new ANTEState();

    public static ANTEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> this;
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> Zone.ANTE;
            default -> null;
        });
    }
}
