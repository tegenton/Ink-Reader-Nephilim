package tegenton.card.lexer.dfa.state.w.h;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.w.WHState;
import tegenton.card.lexer.dfa.state.w.h.e.WHENState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class WHEState extends WHState {
    private static final WHEState INSTANCE = new WHEState();

    /**
     * @return Singleton instance.
     */
    public static WHEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> WHENState.state();
            case 'R' -> new SuffixSubstring("RE", SubordinateConjunction.WHERE);
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
