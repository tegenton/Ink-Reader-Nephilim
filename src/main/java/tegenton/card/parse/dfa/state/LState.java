package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.l.LEState;
import tegenton.card.parse.dfa.state.l.LOState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.Zone;
import java.util.Optional;

public class LState extends State {
    private static final LState INSTANCE = new LState();

    public static LState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> LEState.state();
            case 'I' -> new StateSequence("IBRARY", Zone.LIBRARY);
            case 'O' -> LOState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}