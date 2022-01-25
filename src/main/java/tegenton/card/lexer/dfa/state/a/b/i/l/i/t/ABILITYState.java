package tegenton.card.lexer.dfa.state.a.b.i.l.i.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.b.i.l.i.ABILITState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;

import java.util.Optional;

public class ABILITYState extends ABILITState {
    private static final ABILITYState INSTANCE = new ABILITYState();

    /**
     * @return Singleton instance.
     */
    public static ABILITYState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case ',', '\0', '.', ' ' -> GameNoun.ABILITY;
            default -> null;
        });
    }
}
