package tegenton.card.parse.dfa.state.o;

import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.o.n.ONEState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ONState extends OState {
    private static final ONState instance = new ONState();

    public static ONState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> ONEState.state();
            case 'L' -> new SuffixSubstring("LY", Adverb.ONLY);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0' -> Optional.of(Preposition.ON);
            default -> Optional.empty();
        };
    }
}
