package tegenton.card.lexer.dfa.state.p;

import tegenton.card.lexer.dfa.state.PState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.p.r.PROState;
import tegenton.card.lexer.dfa.state.p.r.e.v.e.n.PREVENTState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class PRState extends PState {
    private static final PRState INSTANCE = new PRState();

    /**
     * @return Singleton instance.
     */
    public static PRState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new InfixSubstring("EVEN", 'T', PREVENTState::state);
            case 'O' -> PROState.state();
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
