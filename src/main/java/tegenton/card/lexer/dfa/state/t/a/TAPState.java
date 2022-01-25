package tegenton.card.lexer.dfa.state.t.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.TAState;
import tegenton.card.lexer.dfa.state.t.a.p.TAPPState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class TAPState extends TAState {
    private static final TAPState INSTANCE = new TAPState();

    /**
     * @return Singleton instance.
     */
    public static TAPState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'P' -> TAPPState.state();
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
        return switch (c) {
            case '\0', ' ' -> Optional.of(ObjectVerb.TAP);
            default -> Optional.empty();
        };
    }
}
