package tegenton.card.parse.dfa.state.t.h.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THEState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetNoun;

import java.util.Optional;

public class THEMState extends THEState {
    private static final THEMState INSTANCE = new THEMState();

    public static THEMState state() {
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
        return switch (c) {
            case '\0', ' ' -> Optional.of(TargetNoun.THEM);
            default -> Optional.empty();
        };
    }
}
