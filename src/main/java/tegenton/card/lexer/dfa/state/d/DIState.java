package tegenton.card.lexer.dfa.state.d;

import tegenton.card.lexer.dfa.state.DState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.d.i.DIEState;
import tegenton.card.lexer.dfa.state.d.i.s.c.a.r.DISCARDState;
import tegenton.card.lexer.dfa.state.d.i.v.i.d.DIVIDEState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class DIState extends DState {
    private static final DIState INSTANCE = new DIState();

    /**
     * @return Singleton instance.
     */
    public static DIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> DOState.state();
            case 'E' -> DIEState.state();
            case 'F' -> new SuffixSubstring("FFERENT", Adjective.DIFFERENT);
            case 'S' -> new InfixSubstring("SCAR", 'D', DISCARDState::state);
            case 'V' -> new InfixSubstring("VID", 'E', DIVIDEState::state);
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
