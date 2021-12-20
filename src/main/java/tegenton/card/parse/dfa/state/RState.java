package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.r.REState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Color;

import java.util.Optional;

public class RState extends State {
    private static final RState INSTANCE = new RState();

    public static RState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ANDOM", Noun.RANDOM);
            case 'E' -> REState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '}', '\0', ' ' -> Color.R;
            default -> null;
        });
    }
}
