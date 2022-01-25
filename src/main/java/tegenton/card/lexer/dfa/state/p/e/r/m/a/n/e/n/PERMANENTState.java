package tegenton.card.lexer.dfa.state.p.e.r.m.a.n.e.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.PState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;

import java.util.Optional;

public class PERMANENTState extends PState {
    private static final PERMANENTState INSTANCE = new PERMANENTState();

    /**
     * @return Singleton instance.
     */
    public static PERMANENTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\0', '.', ' ' -> ObjectNoun.PERMANENT;
            default -> null;
        });
    }
}
