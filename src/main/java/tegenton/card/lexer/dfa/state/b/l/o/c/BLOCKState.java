package tegenton.card.lexer.dfa.state.b.l.o.c;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.b.BLState;
import tegenton.card.lexer.dfa.state.b.l.o.c.k.BLOCKEState;
import tegenton.card.lexer.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class BLOCKState extends BLState {
    private static final BLOCKState INSTANCE = new BLOCKState();

    /**
     * @return Singleton instance.
     */
    public static BLOCKState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> BLOCKEState.state();
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
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'E', 'I', '\0', ' ' -> ObjectVerb.BLOCK;
            default -> null;
        });
    }
}
