package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.w.WAState;
import tegenton.card.lexer.dfa.state.w.WHState;
import tegenton.card.lexer.dfa.state.w.WOState;
import tegenton.card.lexer.dfa.state.w.i.t.WITHState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Color;
import tegenton.card.lexicon.game.GameVerb;

import java.util.Optional;

public class WState extends tegenton.card.lexer.dfa.state.State {
    private static final WState INSTANCE = new WState();

    /**
     * @return Singleton instance.
     */
    public static tegenton.card.lexer.dfa.state.State state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> WAState.state();
            case 'E' -> new SuffixSubstring("ERE", Morpheme.ED);
            case 'H' -> WHState.state();
            case 'I' -> new InfixSubstring("IT", 'H', WITHState::state);
            case 'O' -> WOState.state();
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
            case 'E' -> GameVerb.BE;
            case '}', '\0', ' ' -> Color.W;
            default -> null;
        });
    }
}
