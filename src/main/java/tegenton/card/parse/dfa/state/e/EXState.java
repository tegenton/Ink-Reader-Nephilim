package tegenton.card.parse.dfa.state.e;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.Zone;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
import java.util.Optional;

public class EXState extends EState {
    private static final EXState INSTANCE = new EXState();

    public static EXState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'C' -> new StateSequence("CHANGE", PlayerVerb.EXCHANGE);
            case 'I' -> new StateSequence("ILE", Zone.EXILE);
            default -> throw new IllegalStateException(
                    "Cannot transition from EXState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
