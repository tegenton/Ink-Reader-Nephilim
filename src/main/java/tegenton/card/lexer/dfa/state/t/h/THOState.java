package tegenton.card.lexer.dfa.state.t.h;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.THState;
import tegenton.card.lexer.dfa.state.t.h.o.THOSState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class THOState extends THState {
    private static final THOState INSTANCE = new THOState();

    /**
     * @return Singleton instance.
     */
    public static THOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> THOSState.state();
            case 'U' -> new SuffixSubstring("UGH",
                    SubordinateConjunction.THOUGH);
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
