package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.u.UNState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.turn.Step;

import java.util.Optional;

public class UState extends State {
    private static final UState INSTANCE = new UState();

    public static UState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> UNState.state();
            case 'P' -> new SuffixSubstring("PKEEP", Step.UPKEEP);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
