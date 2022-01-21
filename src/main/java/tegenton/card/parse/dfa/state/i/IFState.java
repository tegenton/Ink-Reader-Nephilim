package tegenton.card.parse.dfa.state.i;

import tegenton.card.parse.dfa.state.IState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.lexicon.SubordinateConjunction;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class IFState extends IState {
    private static final IFState INSTANCE = new IFState();

    public static IFState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> SubordinateConjunction.IF;
            default -> null;
        });
    }
}
