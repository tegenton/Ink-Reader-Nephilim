package tegenton.card.lexer.dfa.state.f;

import tegenton.card.lexer.dfa.state.FState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.f.o.FORState;
import tegenton.card.lexer.dfa.state.f.o.FOUState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class FOState extends FState {
    private static final FOState INSTANCE = new FOState();

    /**
     * @return Singleton instance.
     */
    public static FOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'O' -> new SuffixSubstring("OT", Noun.FOOT);
            case 'R' -> FORState.state();
            case 'U' -> FOUState.state();
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
