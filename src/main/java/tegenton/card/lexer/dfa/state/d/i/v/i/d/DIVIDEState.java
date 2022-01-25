package tegenton.card.lexer.dfa.state.d.i.v.i.d;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.d.DIState;
import tegenton.card.lexer.dfa.state.e.EDState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class DIVIDEState extends DIState {
    private static final DIVIDEState INSTANCE = new DIVIDEState();

    /**
     * @return Singleton instance.
     */
    public static DIVIDEState state() {
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
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'D', '\0', ' ' -> PlayerVerb.DIVIDE;
            default -> null;
        });
    }
}
