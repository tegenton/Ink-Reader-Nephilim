package tegenton.card.lexer.tokenizer.transition;

import java.util.HashMap;
import java.util.Map;

public class TransitionFactory {
    private static final Map<Character, Transition> basic = new HashMap<>();

    public static Transition getTransition(char c) {
        if (!basic.containsKey(c)) {
            basic.put(c, new Transition(c));
        }
        return basic.get(c);
    }
}
