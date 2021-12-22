package tegenton.card.parse.dfa.state.d.e.a.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.d.DEState;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class DEALTState extends DEState {
    private static final DEALTState INSTANCE = new DEALTState();

    public static DEALTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Morpheme.ED;
            default -> null;
        });
    }
}
