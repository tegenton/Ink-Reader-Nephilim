package tegenton.card.lexer.dfa.state.d.i;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.d.DIState;
import tegenton.card.lexer.dfa.state.e.EDState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class DIEState extends DIState {
    private static final DIEState INSTANCE = new DIEState();

    /**
     * @return Singleton instance.
     */
    public static DIEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
            case 'S' -> this;
            case ',', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'D', ',', '\0', ' ' -> ObjectVerb.DIE;
            default -> null;
        });
    }
}
