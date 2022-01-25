package tegenton.card.lexer.dfa.state.c;

import tegenton.card.lexer.dfa.state.CState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.a.CANState;
import tegenton.card.lexer.dfa.state.c.a.CARState;
import tegenton.card.lexer.dfa.state.c.a.s.CASTState;
import tegenton.card.lexer.dfa.state.c.a.u.s.CAUSEState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class CAState extends CState {
    private static final CAState INSTANCE = new CAState();

    /**
     * @return Singleton instance.
     */
    public static CAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> CANState.state();
            case 'R' -> CARState.state();
            case 'S' -> new InfixSubstring("S", 'T', CASTState::state);
            case 'U' -> new InfixSubstring("US", 'E', CAUSEState::state);
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
