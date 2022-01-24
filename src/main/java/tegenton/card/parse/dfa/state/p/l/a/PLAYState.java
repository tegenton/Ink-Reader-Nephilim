package tegenton.card.parse.dfa.state.p.l.a;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.p.l.PLAState;
import tegenton.card.parse.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

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
