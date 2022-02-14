package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexicon.Word;

import java.util.Map;
import java.util.function.Consumer;

public abstract class State {
    private final String name;

    protected State(final String s) {
        this.name = s;
    }

    /**
     * @return Instance of initial (empty) state.
     */
    public static State empty() {
        return new BaseState("");
    }

    /**
     * Follow a transition to the next state.
     *
     * @param setState Consumer that accepts the next state.
     * @param addToken Consumer that accepts products of this transition, if
     *                 any.
     * @param c        Character to transition on.
     */
    public void accept(final Consumer<String> setState,
                       final Consumer<Word> addToken, final char c) {
        Map<String, Map<Character, Transition>> state = transitions();
        if (state.containsKey(name)) {
            Map<Character, Transition> transitions = state.get(name);
            if (transitions.containsKey(c)) {
                setState.accept(transitions.get(c).accept(addToken, name));
                return;
            }
            throw new IllegalStateException(
                    "Could not transition from state '%s' on '%s'.".formatted(
                            name, c));
        }
        throw new IllegalStateException("State '" + name + "' not found.");
    }

    /**
     * Each state uses logic from the abstract State class, but contains
     * different transitions. This function allows the abstract logic to access
     * the specific transitions of a particular state.
     *
     * @return Map of states and transitions.
     */
    protected abstract Map<String, Map<Character, Transition>> transitions();
}
