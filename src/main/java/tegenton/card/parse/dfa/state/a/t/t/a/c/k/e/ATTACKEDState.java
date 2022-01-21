package tegenton.card.parse.dfa.state.a.t.t.a.c.k.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.t.t.a.c.k.ATTACKEState;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ATTACKEDState extends ATTACKEState {
    private static final ATTACKEDState INSTANCE = new ATTACKEDState();

    public static ATTACKEDState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Morpheme.ED;
            default -> null;
        });
    }
}
