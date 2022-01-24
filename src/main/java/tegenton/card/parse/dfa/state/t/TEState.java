package tegenton.card.parse.dfa.state.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.dfa.state.t.e.TENState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;

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
