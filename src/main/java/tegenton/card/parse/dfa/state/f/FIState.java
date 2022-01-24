package tegenton.card.parse.dfa.state.f;

import tegenton.card.parse.dfa.state.FState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.i.FIFState;
import tegenton.card.parse.dfa.state.f.i.FIVState;
import tegenton.card.parse.dfa.state.f.i.n.i.s.FINISHState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adjective;
import tegenton.card.parse.lexicon.Word;

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
