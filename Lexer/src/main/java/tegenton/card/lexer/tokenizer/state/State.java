package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.Tokenizer;

import java.util.List;
import java.util.Map;

public abstract class State {
    private final String name;

    protected State(String name) {
        this.name = name;
    }

    public static State empty() {
        return new BaseState("");
    }

    public void accept(Tokenizer tokenizer, char c) {
        for (Transition transition : transitions().get(name)) {
            if (transition.contains(c)) {
                tokenizer.setState(transition.accept(tokenizer, name));
                return;
            }
        }
        throw new IllegalStateException(
                "Could not transition from state '" + name + "' on '" + c
                + "'.");
    }

    protected abstract Map<String, List<Transition>> transitions();
}
