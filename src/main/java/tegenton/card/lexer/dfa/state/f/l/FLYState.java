package tegenton.card.lexer.dfa.state.f.l;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.f.FLState;
import tegenton.card.lexer.dfa.state.f.l.y.i.n.FLYINGState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class FLYState extends FLState {
    private static final FLYState INSTANCE = new FLYState();

    /**
     * @return Singleton instance.
     */
    public static FLYState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new InfixSubstring("IN", 'G', FLYINGState::state);
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
