package tegenton.card.parse.dfa.state.n.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.dfa.state.n.NOState;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class NONState extends NOState {
    private static final NONState INSTANCE = new NONState();

    public static NONState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> TState.state();
            case '-', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'T', '-', '\0', ' ' -> Adverb.NOT;
            default -> null;
        });
    }
}
