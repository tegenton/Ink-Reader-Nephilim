package tegenton.card.parse.dfa.state.a.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.ALState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ALLState extends ALState {
    private static final ALLState INSTANCE = new ALLState();

    public static ALLState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Determiner.ALL;
            default -> null;
        });
    }
}
