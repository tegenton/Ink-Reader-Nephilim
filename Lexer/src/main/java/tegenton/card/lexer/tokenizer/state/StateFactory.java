package tegenton.card.lexer.tokenizer.state;

import java.util.HashMap;
import java.util.Map;

public final class StateFactory {
    private static final Map<String, State> STATES = new HashMap<>();

    private StateFactory() {
    }

    /**
     * Retrieve a state by name.
     *
     * @param name Name of state to retrieve
     * @return Instance of named state.
     */
    public static State getState(final String name) {
        if (!STATES.containsKey(name)) {
            if (name.length() < 2) {
                STATES.put(name, new BaseState(name));
            } else {
                STATES.put(name, switch (name.charAt(0)) {
                    case 'A' -> new AState(name);
                    case 'B' -> new BState(name);
                    case 'C' -> new CState(name);
                    case 'D' -> new DState(name);
                    case 'E' -> new EState(name);
                    case 'F' -> new FState(name);
                    case 'G' -> new GState(name);
                    case 'H' -> new HState(name);
                    case 'I' -> new IState(name);
                    case 'L' -> new LState(name);
                    case 'P' -> new PState(name);
                    case 'T' -> new TState(name);
                    default -> throw new IllegalStateException(
                            "No state '" + name + "'.");
                });

            }
        }
        return STATES.get(name);
    }
}
