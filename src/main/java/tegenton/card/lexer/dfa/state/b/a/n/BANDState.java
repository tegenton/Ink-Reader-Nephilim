package tegenton.card.lexer.dfa.state.b.a.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.b.a.BANState;
import tegenton.card.lexer.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;

import java.util.Optional;

public class BANDState extends BANState {
    private static final BANDState INSTANCE = new BANDState();

    /**
     * @return Singleton instance.
     */
    public static BANDState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new INGMorpheme(Keyword.BANDING);
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
