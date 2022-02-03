package tegenton.card.lexer.tokenizer.state;

import java.util.HashMap;
import java.util.Map;

public class StateFactory {
    private static final Map<String, State> states = new HashMap<>();

    public static State getState(String k) {
        if (!states.containsKey(k)) {
            if (k.length() < 2) {
                states.put(k, new BaseState(k));
            } else {
                states.put(k, switch (k.charAt(0)) {
                    case 'B' -> new BState(k);
                    default -> throw new IllegalStateException(
                            "No state '" + k + "'.");
                });

            }
        }
        return states.get(k);
    }
}
