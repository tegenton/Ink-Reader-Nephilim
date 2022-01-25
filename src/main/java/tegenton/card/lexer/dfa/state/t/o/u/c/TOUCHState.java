package tegenton.card.lexer.dfa.state.t.o.u.c;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.o.TOUState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameVerb;

import java.util.Optional;

public class TOUCHState extends TOUState {
    private static final TOUCHState INSTANCE = new TOUCHState();

    /**
     * @return Singleton instance.
     */
    public static TOUCHState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new InfixSubstring("E", 'S', TOUCHState::state);
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
            case '\0', '.', ' ' -> GameVerb.TOUCH;
            default -> null;
        });
    }
}
