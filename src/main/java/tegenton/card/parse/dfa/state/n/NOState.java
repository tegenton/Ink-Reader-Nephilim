package tegenton.card.parse.dfa.state.n;

import tegenton.card.parse.dfa.state.NState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.n.o.NONState;
import tegenton.card.parse.dfa.state.n.o.NOTState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class NOState extends NState {
    private static final NOState INSTANCE = new NOState();

    public static NOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> NONState.state();
            case 'T' -> NOTState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Determiner.NO;
            default -> null;
        });
    }
}
