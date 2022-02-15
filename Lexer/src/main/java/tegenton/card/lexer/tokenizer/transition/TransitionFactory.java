package tegenton.card.lexer.tokenizer.transition;

import tegenton.card.lexicon.NounWord;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.VerbWord;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.CostSymbol;

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

    public static Map<Character, Transition> mapOf(final CostSymbol word,
                                                   final char... labels) {
        final Map<Character, Transition> transitions = mapOf(labels);
        transitions.putAll(toWord(word));
        transitions.put('}', new Transition('}', word, "}"));
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

    public static Map<Character, Transition> mapOf(final VerbWord verb) {
        final Map<Character, Transition> map = toWord(verb);
        map.put('E', new Transition('E', verb, "E"));
        map.put('I', new Transition('I', verb, "I"));
        map.put('S', TransitionFactory.getTransition());
        return map;
    }

    /**
     * Generate transitions for the end of a word.
     *
     * @param word Product.
     * @return Transitions on space or a null terminator producing that word.
     */
    public static Map<Character, Transition> toWord(final Word word) {
        final Map<Character, Transition> map = new HashMap<>();
        map.put(',', new Transition(',', word, ","));
        map.put('\0', new Transition('\0', word, ""));
        map.put('\n', new Transition('\n', word, "\n"));
        map.put('.', new Transition('.', word, "."));
        map.put(';', new Transition(';', word, ";"));
        map.put(' ', new Transition(' ', word, " "));
        return map;
    }

    public static Map<Character, Transition> mapOf(final NounWord noun) {
        final Map<Character, Transition> map = toWord(noun);
        map.put('E', new Transition('E', noun, "E"));
        map.put('S', new Transition('S', noun, "S"));
        map.put('\'', new Transition('\'', noun, "'"));
        return map;
    }

    public static Map<Character, Transition> toSymbol(final Symbol symbol,
                                                      final char... labels) {
        final Map<Character, Transition> transitions = new HashMap<>();
        for (final char c : labels) {
            transitions.put(c,
                    new Transition(c, symbol, Character.toString(c)));
        }
        transitions.put('\0', new Transition('\0', symbol, ""));
        return transitions;
    }
}
