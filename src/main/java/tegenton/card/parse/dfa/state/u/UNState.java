package tegenton.card.parse.dfa.state.u;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.UState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
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
            case 'D' -> new SuffixSubstring("DER", Preposition.UNDER);
            case 'T' -> new SuffixSubstring("TIL", Preposition.UNTIL);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
