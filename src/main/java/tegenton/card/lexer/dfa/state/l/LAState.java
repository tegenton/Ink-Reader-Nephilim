package tegenton.card.lexer.dfa.state.l;

import tegenton.card.lexer.dfa.state.LState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.l.a.n.LANDState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class LAState extends LState {
    private static final LAState INSTANCE = new LAState();

    /**
     * @return Singleton instance.
     */
    public static LAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'B' -> new SuffixSubstring("BEL", Noun.LABEL);
            case 'N' -> new InfixSubstring("N", 'D', LANDState::state);
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
