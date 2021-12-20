package tegenton.card.parse.dfa.state.i.n.s.t.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.n.INSState;
import tegenton.card.parse.dfa.state.i.n.s.t.a.n.INSTANTState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class INSTANState extends INSState {
    private static final INSTANState INSTANCE = new INSTANState();

    public static INSTANState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'C' -> new SuffixSubstring("CE", Noun.INSTANCE);
            case 'T' -> INSTANTState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
