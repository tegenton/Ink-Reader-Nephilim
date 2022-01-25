package tegenton.card.lexer.dfa.state.f;

import tegenton.card.lexer.dfa.state.FState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.f.i.FIFState;
import tegenton.card.lexer.dfa.state.f.i.FIVState;
import tegenton.card.lexer.dfa.state.f.i.n.i.s.FINISHState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class FIState extends FState {
    private static final FIState INSTANCE = new FIState();

    /**
     * @return Singleton instance.
     */
    public static FIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'F' -> FIFState.state();
            case 'N' -> new InfixSubstring("NIS", 'H', FINISHState::state);
            case 'R' -> new SuffixSubstring("RST", Adjective.FIRST);
            case 'V' -> FIVState.state();
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
