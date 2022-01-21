package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.d.DEState;
import tegenton.card.parse.dfa.state.d.DIState;
import tegenton.card.parse.dfa.state.d.DOState;
import tegenton.card.parse.dfa.state.d.DRState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;
import tegenton.card.parse.lexicon.game.turn.Chronology;

import java.util.Optional;

public class DState extends State {
    private static final DState INSTANCE = new DState();

    public static DState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("AMAGE", GameNoun.DAMAGE);
            case 'E' -> DEState.state();
            case 'O' -> DOState.state();
            case 'I' -> DIState.state();
            case 'R' -> DRState.state();
            case 'U' -> new SuffixSubstring("URING", Chronology.DURING);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
