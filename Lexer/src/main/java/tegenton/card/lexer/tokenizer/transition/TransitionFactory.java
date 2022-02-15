package tegenton.card.lexer.tokenizer.transition;

import tegenton.card.lexicon.Word;

import java.util.HashMap;
import java.util.Map;

public final class TransitionFactory {
    private static final Map<Character, Transition> BASIC = new HashMap<>();

    private TransitionFactory() {
    }

    private static Transition getTransition() {
        if (!BASIC.containsKey(null)) {
            BASIC.put(null, new Transition());
        }
        return BASIC.get(null);
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
    public static Map<Character, Transition> mapOf(final Word word,
                                                   final char... labels) {
        final Map<Character, Transition> transitions = mapOf(labels);
        transitions.putAll(toWord(word));
        return transitions;
    }

    /**
     * Generate a transition set for a state.
     *
     * @param labels Transitions from this state on other characters.
     * @return List of transitions for this state.
     */
    public static Map<Character, Transition> mapOf(final char... labels) {
        final Map<Character, Transition> transitions = new HashMap<>();
        for (final char c : labels) {
            transitions.put(c, getTransition(c));
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
    public static void sequence(
            final Map<String, Map<Character, Transition>> map,
            final String start, final String end) {
        final StringBuilder builder = new StringBuilder(start);
        for (final char c : end.toCharArray()) {
            if (map.put(builder.toString(), mapOf(c)) != null) {
                throw new UnsupportedOperationException(builder.toString());
            }
            builder.append(c);
        }
    }

    /**
     * Generate transitions for the end of a word.
     *
     * @param word Product.
     * @return Transitions on space or a null terminator producing that word.
     */
    public static Map<Character, Transition> toWord(final Word word) {
        return Map.of('\0', new Transition('\0', word, ""), '\n',
                new Transition('\n', word, "\n"), '.',
                new Transition('.', word, "."), ' ',
                new Transition(' ', word, " "));
    }

    public static Map<Character, Transition> toNoun(final Word word) {
        return Map.of('S', new Transition('S', word, "S"), '\0',
                new Transition('\0', word, ""), '\n',
                new Transition('\n', word, "\n"), '.',
                new Transition('.', word, "."), ' ',
                new Transition(' ', word, " "));
    }

    public static Map<Character, Transition> toVerb(final Word word) {
        return Map.of('S', TransitionFactory.getTransition(), '\0',
                new Transition('\0', word, ""), '\n',
                new Transition('\n', word, "\n"), '.',
                new Transition('.', word, "."), ' ',
                new Transition(' ', word, " "));
    }
}
