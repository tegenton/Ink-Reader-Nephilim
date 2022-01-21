package tegenton.card.parse.dfa.state.u.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.TAState;
import tegenton.card.parse.dfa.state.u.UNState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.turn.Duration;

import java.util.Optional;

public class UNTState extends UNState {
    private static final UNTState INSTANCE = new UNTState();

    public static UNTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> TAState.state();
            case 'I' -> new SuffixSubstring("IL", Duration.UNTIL);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'A' -> Adverb.NOT;
            default -> null;
        });
    }
}
