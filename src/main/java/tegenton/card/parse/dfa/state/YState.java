package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.y.o.YOUState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.value.Variable;

import java.util.Optional;

public class YState extends State {
    private static final YState INSTANCE = new YState();

    public static YState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'O' -> new InfixSubstring("O", 'U', YOUState::state);
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Variable.Y;
            default -> null;
        });
    }
}