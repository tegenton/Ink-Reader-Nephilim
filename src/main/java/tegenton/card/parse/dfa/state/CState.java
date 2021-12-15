package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.c.CAState;
import tegenton.card.parse.dfa.state.c.CHState;
import tegenton.card.parse.dfa.state.c.COState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.player.PlayerVerb;
import java.util.Optional;

public class CState extends State {
    private static final CState INSTANCE = new CState();

    public static CState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> CAState.state();
            case 'H' -> CHState.state();
            case 'O' -> COState.state();
            case 'R' -> new StateSequence("REATE", PlayerVerb.CREATE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
