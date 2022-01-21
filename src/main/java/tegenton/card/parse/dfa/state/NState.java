package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.n.NEState;
import tegenton.card.parse.dfa.state.n.NIState;
import tegenton.card.parse.dfa.state.n.NOState;
import tegenton.card.parse.dfa.state.n.a.m.NAMEState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class NState extends State {
    private static final NState INSTANCE = new NState();

    public static NState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new InfixSubstring("AM", 'E', NAMEState::state);
            case 'E' -> NEState.state();
            case 'I' -> NIState.state();
            case 'O' -> NOState.state();
            case 'U' -> new SuffixSubstring("UMBER", Noun.NUMBER);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
