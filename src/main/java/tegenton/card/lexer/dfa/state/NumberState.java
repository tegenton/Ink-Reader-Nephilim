package tegenton.card.lexer.dfa.state;

import tegenton.card.lexicon.value.Number;
import tegenton.card.lexicon.value.ValueWord;

import java.util.Optional;

public final class NumberState extends State {
    private static final int LEFT_SHIFT = 10;
    private int number;

    /**
     * Enter NumberState with a given value.
     *
     * @param i Integer value
     */
    public NumberState(final int i) {
        number = i;
    }

    /**
     * @param c Character used to transition into this state.
     * @return Instance of number state with given value.
     */
    public static NumberState state(final char c) {
        return new NumberState(c - '0');
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', '.', '}', '/', ' ' -> SymbolState.state(c);
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                number *= LEFT_SHIFT;
                number += c - '0';
                yield this;
            }
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<ValueWord> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', '}', '/', ' ' -> Number.valueOf(number);
            default -> null;
        });
    }
}
