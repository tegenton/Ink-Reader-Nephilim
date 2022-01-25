package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.n.NEState;
import tegenton.card.lexer.dfa.state.n.NIState;
import tegenton.card.lexer.dfa.state.n.NOState;
import tegenton.card.lexer.dfa.state.n.a.m.NAMEState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class NState extends State {
    private static final NState INSTANCE = new NState();

    /**
     * @return Singleton instance.
     */
    public static NState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
