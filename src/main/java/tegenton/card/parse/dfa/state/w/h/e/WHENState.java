package tegenton.card.parse.dfa.state.w.h.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.w.h.WHEState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.game.TriggerWord;
import java.util.Optional;

public final class WHENState extends WHEState {
    private static final WHENState INSTANCE = new WHENState();

    public static WHENState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new SuffixSubstring("EVER", TriggerWord.WHENEVER);
            case ' ' -> SymbolState.state(c);
            default -> throw new IllegalStateException(
                    "Cannot transition from WHENState on " + c);
        };
    }

    @Override
    public Optional<TriggerWord> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(TriggerWord.WHEN);
            default -> Optional.empty();
        };
    }
}
