package tegenton.card.parse.dfa.state.i.n.s.t.a.n.c;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.i.n.s.t.a.n.INSTANCState;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class INSTANCEState extends INSTANCState {
    private static final INSTANCEState INSTANCE = new INSTANCEState();

    public static INSTANCEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\0', ' ' -> Noun.INSTANCE;
            default -> null;
        });
    }
}
