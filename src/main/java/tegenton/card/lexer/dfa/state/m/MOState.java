package tegenton.card.lexer.dfa.state.m;

import tegenton.card.lexer.dfa.state.MState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.m.o.MORState;
import tegenton.card.lexer.dfa.state.m.o.u.n.t.a.i.MOUNTAINState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class MOState extends MState {
    private static final MOState INSTANCE = new MOState();

    /**
     * @return Singleton instance.
     */
    public static MOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> MORState.state();
            case 'U' -> new InfixSubstring("UNTAI", 'N', MOUNTAINState::state);
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
