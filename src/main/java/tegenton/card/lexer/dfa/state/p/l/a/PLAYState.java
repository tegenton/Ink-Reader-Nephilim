package tegenton.card.lexer.dfa.state.p.l.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.EState;
import tegenton.card.lexer.dfa.state.p.l.PLAState;
import tegenton.card.lexer.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class PLAYState extends PLAState {
    private static final PLAYState INSTANCE = new PLAYState();

    /**
     * @return Singleton instance.
     */
    public static PLAYState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> EState.state();
            case 'I' -> new INGMorpheme();
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<PlayerVerb> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'E', 'I', '\0', ' ' -> PlayerVerb.PLAY;
            default -> null;
        });
    }
}
