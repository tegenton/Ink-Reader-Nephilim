package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.r.RAState;
import tegenton.card.parse.dfa.state.r.REState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adjective;
import tegenton.card.parse.lexicon.Particle;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Color;

import java.util.Optional;

public class RState extends State {
    private static final RState INSTANCE = new RState();

    public static RState state() {
        return INSTANCE;
    }

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

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '}', '\0', ' ' -> Color.R;
            default -> null;
        });
    }
}
