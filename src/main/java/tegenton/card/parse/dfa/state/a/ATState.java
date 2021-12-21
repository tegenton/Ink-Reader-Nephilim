package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.t.ATTState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.TriggerWord;

import java.util.Optional;

public class ATState extends AState {
    private static final ATState INSTANCE = new ATState();

    public static ATState state() {
        return INSTANCE;
    }

    public State transition(final char c) {
        return switch (c) {
            case 'T' -> ATTState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(TriggerWord.AT);
            default -> Optional.empty();
        };
    }
}
