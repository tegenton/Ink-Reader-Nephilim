package tegenton.card.lexer.dfa.state.i;

import tegenton.card.lexer.dfa.state.IState;
import tegenton.card.lexer.dfa.state.PossessiveState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class ITState extends IState {
    private static final ITState INSTANCE = new ITState();

    /**
     * @return Singleton instance.
     */
    public static ITState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> PossessiveState.state();
            case '\u2019' -> new SuffixSubstring("\u2019S", ObjectVerb.IS);
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\u2019', ',', '\0', '.', ' ' -> ObjectNoun.IT;
            default -> null;
        });
    }
}
