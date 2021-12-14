package tegenton.card.parse.dfa.state.morpheme;

import tegenton.card.parse.dfa.state.SpaceState;
import tegenton.card.parse.dfa.state.State;
import java.util.Arrays;

public abstract class Morpheme extends State {
    private final char[] text;
    private int index = 1;

    protected Morpheme(char[] text) {
        this.text = text;
    }

    public State transition(char c) {
        if (index < text.length && c == text[index]) {
            index++;
            return this;
        } else if (index < text.length) {
            throw new IllegalStateException("Morpheme " + Arrays.toString(text) + " does not contain " + c);
        } else {
            return switch (c) {
                case ' ' -> SpaceState.state();
                default -> throw new IllegalStateException("Cannot transition from morpheme " + Arrays.toString(text) + " on " + c);
            };
        }
    }

    protected boolean completed() {
        return index == text.length;
    }
}
