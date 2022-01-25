package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.r.RAState;
import tegenton.card.lexer.dfa.state.r.REState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Color;

import java.util.Optional;

public class RState extends State {
    private static final RState INSTANCE = new RState();

    /**
     * @return Singleton instance.
     */
    public static RState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> RAState.state();
            case 'E' -> REState.state();
            case 'I' -> new SuffixSubstring("IGHT", Particle.RIGHT);
            case 'O' -> new SuffixSubstring("OUNDED", Adjective.ROUNDED);
            case '}', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '}', '\0', ' ' -> Color.R;
            default -> null;
        });
    }
}
