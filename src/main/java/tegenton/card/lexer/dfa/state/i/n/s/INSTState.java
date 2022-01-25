package tegenton.card.lexer.dfa.state.i.n.s;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.i.n.INSState;
import tegenton.card.lexer.dfa.state.i.n.s.t.INSTAState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class INSTState extends INSState {
    private static final INSTState INSTANCE = new INSTState();

    /**
     * @return Singleton instance.
     */
    public static INSTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> INSTAState.state();
            case 'E' -> new SuffixSubstring("EAD", Adverb.INSTEAD);
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
