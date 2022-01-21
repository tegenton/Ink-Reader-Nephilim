package tegenton.card.parse.dfa.substring;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;

import java.util.Arrays;

public abstract class Substring extends State {
    private final char[] text;
    private int index = 1;

    protected Substring(final char[] text) {
        this.text = text;
    }

    public State transition(final char c) {
        if (index < text.length && c == text[index]) {
            index++;
            return this;
        } else if (index < text.length) {
            throw new IllegalStateException("Substring " + Arrays.toString(text) + " does not contain " + c + " at index " + index);
        } else {
            return switch (c) {
                case ',', '\n', '.', '\u201D', ' ' -> SymbolState.state(c);
                default -> throw new IllegalStateException("Cannot transition from substring " + Arrays.toString(text) + " on " + c);
            };
        }
    }

    protected boolean completed() {
        return index == text.length;
    }
}
