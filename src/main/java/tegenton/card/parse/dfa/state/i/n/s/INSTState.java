package tegenton.card.parse.dfa.state.i.n.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.n.INSState;
import tegenton.card.parse.dfa.state.i.n.s.t.INSTAState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class INSTState extends INSState {
    private static final INSTState INSTANCE = new INSTState();

    public static INSTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> INSTAState.state();
            case 'E' -> new SuffixSubstring("EAD", Adverb.INSTEAD);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
