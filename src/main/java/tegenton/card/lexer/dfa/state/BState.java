package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.b.BAState;
import tegenton.card.lexer.dfa.state.b.BEState;
import tegenton.card.lexer.dfa.state.b.BLState;
import tegenton.card.lexer.dfa.state.b.BYState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Color;

import java.util.Optional;

public class BState extends State {
    private static final BState INSTANCE = new BState();

    /**
     * @return Singleton instance.
     */
    public static BState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> BAState.state();
            case 'E' -> BEState.state();
            case 'L' -> BLState.state();
            case 'U' -> new SuffixSubstring("UT", SubordinateConjunction.BUT);
            case 'Y' -> BYState.state();
            case '}' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '}', '\0', ' ' -> Color.B;
            default -> null;
        });
    }
}
