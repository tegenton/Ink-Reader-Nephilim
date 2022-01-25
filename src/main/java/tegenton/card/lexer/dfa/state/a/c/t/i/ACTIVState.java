package tegenton.card.lexer.dfa.state.a.c.t.i;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.a.c.t.i.v.ACTIVEState;
import tegenton.card.lexer.dfa.state.a.c.t.i.v.a.t.ACTIVATEState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ACTIVState extends AState {
    private static final ACTIVState INSTANCE = new ACTIVState();

    /**
     * @return Singleton instance.
     */
    public static ACTIVState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new InfixSubstring("AT", 'E', ACTIVATEState::state);
            case 'E' -> ACTIVEState.state();
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
