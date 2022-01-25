package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.d.DEState;
import tegenton.card.lexer.dfa.state.d.DIState;
import tegenton.card.lexer.dfa.state.d.DOState;
import tegenton.card.lexer.dfa.state.d.DRState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.turn.Chronology;

import java.util.Optional;

public class DState extends State {
    private static final DState INSTANCE = new DState();

    /**
     * @return Singleton instance.
     */
    public static DState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("AMAGE", GameNoun.DAMAGE);
            case 'E' -> DEState.state();
            case 'O' -> DOState.state();
            case 'I' -> DIState.state();
            case 'R' -> DRState.state();
            case 'U' -> new SuffixSubstring("URING", Chronology.DURING);
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
