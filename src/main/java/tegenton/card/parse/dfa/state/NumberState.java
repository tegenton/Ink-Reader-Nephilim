package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Number;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class NumberState extends State {
    private int number;

    public NumberState(int i) {
        number = i;
    }

    public static State state(char c) {
        return new NumberState(c - '0');
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SpaceState.state();
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                number *= 10;
                number += c - '0';
                yield this;
            }
            default -> throw new IllegalStateException("Cannot transition from NumberState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Number.valueOf(number));
            default -> Optional.empty();
        };
    }
}
