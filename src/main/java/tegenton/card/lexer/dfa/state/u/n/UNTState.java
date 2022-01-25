package tegenton.card.lexer.dfa.state.u.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.TAState;
import tegenton.card.lexer.dfa.state.u.UNState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.turn.Duration;

import java.util.Optional;

public class UNTState extends UNState {
    private static final UNTState INSTANCE = new UNTState();

    /**
     * @return Singleton instance.
     */
    public static UNTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> TAState.state();
            case 'I' -> new SuffixSubstring("IL", Duration.UNTIL);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'A' -> Adverb.NOT;
            default -> null;
        });
    }
}
