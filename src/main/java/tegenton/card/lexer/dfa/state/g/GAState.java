package tegenton.card.lexer.dfa.state.g;

import tegenton.card.lexer.dfa.state.GState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.g.a.i.GAINState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;

import java.util.Optional;

public class GAState extends GState {
    private static final GAState INSTANCE = new GAState();

    /**
     * @return Singleton instance.
     */
    public static GAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new InfixSubstring("I", 'N', GAINState::state);
            case 'M' -> new SuffixSubstring("ME", GameNoun.GAME);
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
