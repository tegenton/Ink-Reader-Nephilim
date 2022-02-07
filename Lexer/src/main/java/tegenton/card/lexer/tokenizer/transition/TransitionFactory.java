package tegenton.card.lexer.tokenizer.transition;

import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TransitionFactory {
    private static final Map<Character, Transition> BASIC = new HashMap<>();

    private TransitionFactory() {
    }

    /**
     * Retrieve one of the basic transitions. These are singleton, and lazily
     * loaded.
     *
     * @param c Character to transition on.
     * @return Basic transition on that character.
     */
    public static Transition getTransition(final char c) {
        if (!BASIC.containsKey(c)) {
            BASIC.put(c, new Transition(c));
        }
        return BASIC.get(c);
    }

    /**
     * Generate a transition set for a state.
     *
     * @param word   Product of this state on space or null terminator.
     * @param labels Transitions from this state on other characters.
     * @return List of transitions for this state.
     */
    public static List<Transition> listOf(final Word word,
                                          final char... labels) {
        List<Transition> transitions = listOf(labels);
        transitions.addAll(toWord(word));
        return transitions;
    }

    /**
     * Generate a transition set for a state.
     *
     * @param labels Transitions from this state on other characters.
     * @return List of transitions for this state.
     */
    public static List<Transition> listOf(final char... labels) {
        List<Transition> transitions = new ArrayList<>();
        for (char c : labels) {
            transitions.add(getTransition(c));
        }
        return transitions;
    }

    /**
     * Generate a linear series of transitions.
     *
     * @param map   Map to add transitions to.
     * @param start Beginning state.
     * @param end   Ending state.
     */
    public static void sequence(final Map<String, List<Transition>> map,
                                final String start, final String end) {
        StringBuilder builder = new StringBuilder(start);
        for (char c : end.toCharArray()) {
            map.put(builder.toString(), listOf(c));
            builder.append(c);
        }
    }

    /**
     * Generate transitions for the end of a word.
     *
     * @param word Product.
     * @return Transitions on space or a null terminator producing that word.
     */
    public static List<Transition> toWord(final Word word) {
        return List.of(new Transition('\0', word, ""),
                new Transition(' ', word, " "));
    }
}
