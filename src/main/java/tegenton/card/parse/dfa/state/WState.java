package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.w.WHState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class WState extends State {
    private static final WState INSTANCE = new WState();

    public static State state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new StateSequence("ALK", Keyword.WALK);
            case 'H' -> WHState.state();
            case 'I' -> new StateSequence("ITH", Preposition.WITH);
            default -> throw new IllegalStateException("Cannot transition from WState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
