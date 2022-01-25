package tegenton.card.lexer.dfa.state.a.t.t.a.c;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.t.t.a.ATTACState;
import tegenton.card.lexer.dfa.state.a.t.t.a.c.k.ATTACKEState;
import tegenton.card.lexer.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class ATTACKState extends ATTACState {
    private static final ATTACKState INSTANCE = new ATTACKState();

    /**
     * @return Singleton instance.
     */
    public static ATTACKState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> ATTACKEState.state();
            case 'I' -> new INGMorpheme();
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
            case 'E', 'I', ',', '\0', ' ' -> ObjectVerb.ATTACK;
            default -> null;
        });
    }
}
