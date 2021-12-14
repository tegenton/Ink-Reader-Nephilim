package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Symbol;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class SymbolState extends State {
    private static final SymbolState INSTANCE = new SymbolState();

    public static SymbolState state(char c) {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from SymbolState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Symbol.PERIOD);
            default -> Optional.empty();
        };
    }
}
