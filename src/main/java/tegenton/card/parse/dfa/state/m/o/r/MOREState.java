package tegenton.card.parse.dfa.state.m.o.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.m.o.MORState;
import tegenton.card.parse.lexicon.Comparative;

import java.util.Optional;

public class MOREState extends MORState {
    private static final MOREState INSTANCE = new MOREState();

    public static MOREState state() {
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
    public Optional<Comparative> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Comparative.MORE;
            default -> null;
        });
    }
}
