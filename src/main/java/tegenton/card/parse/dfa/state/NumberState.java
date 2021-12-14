package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Number;
import tegenton.card.parse.lexicon.ValueWord;
import java.util.Optional;

public final class NumberState extends State {
    private static final int LEFT_SHIFT = 10;
    private int number;

    public NumberState(final int i) {
        number = i;
    }

    public static NumberState state(final char c) {
        return new NumberState(c - '0');
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                number *= LEFT_SHIFT;
                number += c - '0';
                yield this;
            }
            default -> throw new IllegalStateException("Cannot transition from NumberState on " + c);
        };
    }

    @Override
    public Optional<ValueWord> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Number.valueOf(number));
            default -> Optional.empty();
        };
    }
}
