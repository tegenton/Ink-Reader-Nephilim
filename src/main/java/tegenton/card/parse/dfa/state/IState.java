package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.i.INState;
import tegenton.card.parse.dfa.state.i.ISState;
import tegenton.card.parse.dfa.state.i.ITState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
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
            case 'S' -> ISState.state();
            case 'T' -> ITState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
