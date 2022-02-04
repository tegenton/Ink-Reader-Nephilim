package tegenton.card.lexer.tokenizer.transition;

import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransitionFactory {
    private static final Map<Character, Transition> basic = new HashMap<>();

    public static Transition getTransition(char c) {
        if (!basic.containsKey(c)) {
            basic.put(c, new Transition(c));
        }
        return basic.get(c);
    }

    public static List<Transition> listOf(Word word, char... labels) {
        List<Transition> transitions = listOf(labels);
        transitions.addAll(toWord(word));
        return transitions;
    }

    public static List<Transition> listOf(char... labels) {
        List<Transition> transitions = new ArrayList<>();
        for (char c : labels) {
            transitions.add(getTransition(c));
        }
        return transitions;
    }

    public static void sequence(Map<String, List<Transition>> map, String start, String end) {
        StringBuilder builder = new StringBuilder(start);
        for (char c : end.toCharArray()) {
            map.put(builder.toString(), listOf(c));
            builder.append(c);
        }
    }

    public static List<Transition> toWord(Word word) {
        return List.of(new Transition('\0', word, ""),
                new Transition(' ', word, " "));
    }
}
