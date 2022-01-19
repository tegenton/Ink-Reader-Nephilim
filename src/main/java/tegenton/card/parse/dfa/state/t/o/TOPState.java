package tegenton.card.parse.dfa.state.t.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.t.TOState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectAdjective;

import java.util.Optional;

public class TOPState extends TOState {
    private static final TOPState INSTANCE = new TOPState();

    public static TOPState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> ObjectAdjective.TOP;
            default -> null;
        });
    }
}
