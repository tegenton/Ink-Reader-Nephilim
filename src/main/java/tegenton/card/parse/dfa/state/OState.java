package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.o.*;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.player.PlayerNoun;
import java.util.Optional;

public class OState extends State {
    private static final OState INSTANCE = new OState();

    public static OState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'F' -> OFState.state();
            case 'N' -> ONState.state();
            case 'P' -> new StateSequence("PPONENT", PlayerNoun.OPPONENT);
            case 'R' -> ORState.state();
            case 'T' -> OTState.state();
            case 'W' -> OWState.state();
            default -> throw new IllegalStateException("Cannot transition from OState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
