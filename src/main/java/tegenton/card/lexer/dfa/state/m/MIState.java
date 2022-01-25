package tegenton.card.lexer.dfa.state.m;

import tegenton.card.lexer.dfa.state.MState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.CounterName;

import java.util.Optional;

public class MIState extends MState {
    private static final MIState INSTANCE = new MIState();

    /**
     * @return Singleton instance.
     */
    public static MIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NUS", Preposition.MINUS);
            case 'R' -> new SuffixSubstring("RE", CounterName.MIRE);
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
