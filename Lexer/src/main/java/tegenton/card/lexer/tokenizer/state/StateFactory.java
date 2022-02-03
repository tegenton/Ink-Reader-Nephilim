package tegenton.card.lexer.tokenizer.state;

import java.util.HashMap;
import java.util.Map;

public class StateFactory {
    private static final Map<String, State> states = new HashMap<>();

    public static State getState(String k) {
        if (!states.containsKey(k)) {
            states.put(k, null);
        }
        return states.get(k);
    }
}
