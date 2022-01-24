package tegenton.card.parse.dfa.state.p.l.a.n.e.s.w.a.l.k.e;

import tegenton.card.parse.dfa.state.PossessiveState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.p.l.PLAState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class PLANESWALKERState extends PLAState {
    private static final PLANESWALKERState INSTANCE = new PLANESWALKERState();

    /**
     * @return Singleton instance.
     */
    public static PLANESWALKERState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\u2019' -> PossessiveState.state();
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
            case '\0', ' ' -> CardType.PLANESWALKER;
            default -> null;
        });
    }
}
