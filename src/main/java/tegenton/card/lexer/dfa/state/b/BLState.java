package tegenton.card.lexer.dfa.state.b;

import tegenton.card.lexer.dfa.state.BState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.b.l.o.c.BLOCKState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;

import java.util.Optional;

public class BLState extends BState {
    private static final BLState INSTANCE = new BLState();

    /**
     * @return Singleton instance.
     */
    public static BLState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ACK", ColorWord.BLACK);
            case 'O' -> new InfixSubstring("OC", 'K', BLOCKState::state);
            case 'U' -> new SuffixSubstring("UE", ColorWord.BLUE);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
