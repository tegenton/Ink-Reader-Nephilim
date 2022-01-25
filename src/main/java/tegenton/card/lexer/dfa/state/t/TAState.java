package tegenton.card.lexer.dfa.state.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.TState;
import tegenton.card.lexer.dfa.state.t.a.TAPState;
import tegenton.card.lexer.dfa.state.t.a.TARState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class TAState extends TState {
    private static final TAState INSTANCE = new TAState();

    /**
     * @return Singleton instance.
     */
    public static TAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'K' -> new SuffixSubstring("KE", PlayerVerb.TAKE);
            case 'P' -> TAPState.state();
            case 'R' -> TARState.state();
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
