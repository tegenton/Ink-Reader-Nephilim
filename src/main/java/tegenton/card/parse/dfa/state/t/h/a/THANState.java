package tegenton.card.parse.dfa.state.t.h.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THAState;
import tegenton.card.parse.lexicon.Comparative;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THANState extends THAState {
    private static final THANState INSTANCE = new THANState();

    public static THANState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Comparative.THAN;
            default -> null;
        });
    }
}
