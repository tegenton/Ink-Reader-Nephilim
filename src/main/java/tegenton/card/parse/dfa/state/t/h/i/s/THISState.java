package tegenton.card.parse.dfa.state.t.h.i.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.t.h.THIState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THISState extends THIState {
    private static final THISState INSTANCE = new THISState();

    public static THISState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
            default -> throw new IllegalStateException("Cannot transition from THISState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Determiner.THIS;
            default -> null;
        });
    }
}
