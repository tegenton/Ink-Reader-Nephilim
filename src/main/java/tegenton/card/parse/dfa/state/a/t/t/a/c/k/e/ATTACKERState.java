package tegenton.card.parse.dfa.state.a.t.t.a.c.k.e;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.t.t.a.c.k.ATTACKEState;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ATTACKERState extends ATTACKEState {
    private static final ATTACKERState INSTANCE = new ATTACKERState();

    public static ATTACKERState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Morpheme.ER;
            default -> null;
        });
    }
}