package tegenton.card.parse.dfa.state.t.h.e;

import tegenton.card.parse.dfa.state.PossessiveState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THEState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetNoun;

import java.util.Optional;

public class THEIState extends THEState {
    private static final THEIState INSTANCE = new THEIState();

    public static THEIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> PossessiveState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case 'R' -> Optional.of(TargetNoun.THEY);
            default -> Optional.empty();
        };
    }
}
