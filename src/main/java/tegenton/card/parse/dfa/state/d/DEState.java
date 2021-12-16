package tegenton.card.parse.dfa.state.d;

import tegenton.card.parse.dfa.state.DState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
import java.util.Optional;

public class DEState extends DState {
    private static final DEState INSTANCE = new DEState();

    public static DEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'F' -> new StateSequence("FENDER", Keyword.DEFENDER);
            case 'S' -> new StateSequence("STROY", PlayerVerb.DESTROY);
            default -> throw new IllegalStateException(
                    "Cannot transition from DEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
