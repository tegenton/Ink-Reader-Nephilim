package tegenton.card.parse.dfa.state.n.o;

import tegenton.card.parse.dfa.state.*;
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
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> AState.state();
            case 'B' -> BState.state();
            case 'T' -> TState.state();
            case '-', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'A', 'B', 'T', '-', '\0', ' ' -> Adverb.NOT;
            default -> null;
        });
    }
}
