package tegenton.card.lexer.dfa.state.c.a.n.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.c.a.n.CANtState;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class CANTState extends CANtState {
    private static final CANTState INSTANCE = new CANTState();

    /**
     * @return Singleton instance.
     */
    public static CANTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
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
            case ',', '\0', ' ' -> Adverb.NOT;
            default -> null;
        });
    }
}
