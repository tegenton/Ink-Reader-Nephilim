package tegenton.card.lexer.tokenizer.transition;

import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransitionFactory {
    private static final Map<Character, Transition> BASIC = new HashMap<>();

    public static Transition getTransition(final char c) {
        if (!BASIC.containsKey(c)) {
            BASIC.put(c, new Transition(c));
        }
        return BASIC.get(c);
    }

    public static List<Transition> listOf(final Word word, final char... labels) {
        List<Transition> transitions = listOf(labels);
        transitions.addAll(toWord(word));
        return transitions;
    }

    public static List<Transition> listOf(final char... labels) {
        List<Transition> transitions = new ArrayList<>();
        for (char c : labels) {
            transitions.add(getTransition(c));
        }
        return transitions;
    }

    public static void sequence(final Map<String, List<Transition>> map, final String start, final String end) {
        StringBuilder builder = new StringBuilder(start);
        for (char c : end.toCharArray()) {
            map.put(builder.toString(), listOf(c));
            builder.append(c);
        }
    }

    public static List<Transition> toWord(final Word word) {
        return List.of(new Transition('\0', word, ""),
                new Transition(' ', word, " "));
    }
}
