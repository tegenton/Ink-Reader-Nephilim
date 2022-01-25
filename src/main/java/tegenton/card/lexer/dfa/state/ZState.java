package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.z.ZEState;
import tegenton.card.lexer.dfa.state.z.o.m.b.i.ZOMBIEState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ZState extends tegenton.card.lexer.dfa.state.State {
    private static final ZState INSTANCE = new ZState();

    /**
     * @return Singleton instance.
     */
    public static ZState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> ZEState.state();
            case 'O' -> new InfixSubstring("OMBI", 'E', ZOMBIEState::state);
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
