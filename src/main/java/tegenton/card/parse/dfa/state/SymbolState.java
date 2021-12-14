package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Symbol;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class SymbolState extends State {
    private static final SymbolState INSTANCE = new SymbolState();
    private static char symbol;

    public static SymbolState state(char c) {
        symbol = c;
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return EmptyState.state().transition(c);
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (symbol) {
            case ',' -> Symbol.COMMA;
            case '.' -> Symbol.PERIOD;
            case ' ' -> Symbol.SPACE;
            default -> null;
        });
    }
}
