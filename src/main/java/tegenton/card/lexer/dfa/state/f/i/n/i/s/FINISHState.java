package tegenton.card.lexer.dfa.state.f.i.n.i.s;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.f.FIState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameVerb;

import java.util.Optional;

public class FINISHState extends FIState {
    private static final FINISHState INSTANCE = new FINISHState();

    /**
     * @return Singleton instance.
     */
    public static FINISHState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new InfixSubstring("E", 'S', FINISHState::state);
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
            case '\0', ' ' -> GameVerb.FINISH;
            default -> null;
        });
    }
}
