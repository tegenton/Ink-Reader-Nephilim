package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.i.INState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.player.PlayerVerb;
import java.util.Optional;

public class IState extends State {
    private static final IState INSTANCE = new IState();

    public static IState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'G' -> new StateSequence("GNORE", PlayerVerb.IGNORE);
            case 'N' -> INState.state();
            default -> throw new IllegalStateException("Cannot transition from IState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
