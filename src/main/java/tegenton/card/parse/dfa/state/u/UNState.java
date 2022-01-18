package tegenton.card.parse.dfa.state.u;

import tegenton.card.parse.dfa.state.BState;
import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.UState;
import tegenton.card.parse.dfa.state.u.n.UNTState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Conjunction;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class UNState extends UState {
    private static final UNState INSTANCE = new UNState();

    public static UNState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'B' -> BState.state();
            case 'D' -> new SuffixSubstring("DER", Preposition.UNDER);
            case 'L' -> new SuffixSubstring("LESS", Conjunction.UNLESS);
            case 'S' -> SState.state();
            case 'T' -> UNTState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'B', 'S' -> Adverb.NOT;
            default -> null;
        });
    }
}
