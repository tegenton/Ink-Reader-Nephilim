package tegenton.card.parse.dfa.state.t.h.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.t.h.THEState;
import tegenton.card.parse.lexicon.Conjunction;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THENState extends THEState {
    private static final THENState INSTANCE = new THENState();

    public static THENState state() {
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
            case ' ', '\0' -> Conjunction.THEN;
            default -> null;
        });
    }
}
