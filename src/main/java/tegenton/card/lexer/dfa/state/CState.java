package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.c.CAState;
import tegenton.card.lexer.dfa.state.c.CHState;
import tegenton.card.lexer.dfa.state.c.COState;
import tegenton.card.lexer.dfa.state.c.CRState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Color;

import java.util.Optional;

public class CState extends State {
    private static final CState INSTANCE = new CState();

    /**
     * @return Singleton instance.
     */
    public static CState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> CAState.state();
            case 'H' -> CHState.state();
            case 'O' -> COState.state();
            case 'R' -> CRState.state();
            case '}', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '}', '\0', ' ' -> Color.C;
            default -> null;
        });
    }
}
