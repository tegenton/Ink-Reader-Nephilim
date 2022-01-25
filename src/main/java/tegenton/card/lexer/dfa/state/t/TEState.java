package tegenton.card.lexer.dfa.state.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.TState;
import tegenton.card.lexer.dfa.state.t.e.TENState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class TEState extends TState {
    private static final TEState INSTANCE = new TEState();

    /**
     * @return Singleton instance.
     */
    public static TEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> TENState.state();
            case 'X' -> new SuffixSubstring("XT", Noun.TEXT);
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
