package tegenton.card.lexer.dfa.state.c.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.c.CAState;
import tegenton.card.lexer.dfa.state.c.a.n.CANtState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.TargetAuxiliaryVerb;

import java.util.Optional;

public class CANState extends CAState {
    private static final CANState INSTANCE = new CANState();

    /**
     * @return Singleton instance.
     */
    public static CANState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\u2019' -> CANtState.state();
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
            case '\u2019', '\0', ' ' -> TargetAuxiliaryVerb.CAN;
            default -> null;
        });
    }
}
