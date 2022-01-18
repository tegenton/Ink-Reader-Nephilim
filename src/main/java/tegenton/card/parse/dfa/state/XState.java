package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.value.Variable;

import java.util.Optional;

public class XState extends State {
    private static final XState INSTANCE = new XState();

    public static XState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', '}', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '}', '.', ' ' -> Variable.X;
            default -> null;
        });
    }
}
