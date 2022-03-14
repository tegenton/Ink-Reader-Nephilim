package tegenton.card.parser.state;

import tegenton.card.parser.InputItem;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class State {
    private final Set<Production> productions = new HashSet<>();

    public State(Production... productionList) {
        List<Production> propagate =
                new ArrayList<>(Arrays.asList(productionList));
        for (int i = 0; i < propagate.size(); i++) {
            if (propagate.get(i).get(0).hasNode()) {
                for (Production production : propagate.get(i).get(0).getNode()
                        .productions().productions) {
                    if (!propagate.contains(production)) {
                        propagate.add(production);
                    }
                }
            }
        }
        productions.addAll(propagate);
    }

    private State() {

    }

    private void addAll(State closure) {
        productions.addAll(closure.productions);
    }

    public State shift(InputItem next) {
        State newState = new State();
        newState.productions.addAll(
                productions.stream().map(production -> production.shift(next))
                        .filter(Objects::nonNull).collect(Collectors.toSet()));
        return newState;
    }

    public int reducible(InputItem peek) {
        return productions.stream()
                .map(production -> production.reducible(peek))
                .filter(i -> i != -1).findAny().orElse(-1);
    }

    public InputItem reduce(Deque<InputItem> stack,
                            InputItem peek) throws ParseException {
        Production p = productions.stream()
                .filter(production -> production.reducible(peek) != -1)
                .findAny().orElse(null);
        if (p != null) {
            return p.reduce(stack, peek);
        }
        throw new ParseException(
                "Cannot reduce " + stack + " followed by " + peek,
                stack.size());
    }

    public boolean accepting(InputItem peek) {
        Production p = productions.stream()
                .filter(production -> production.reducible(peek) != -1)
                .findAny().orElse(null);
        if (p != null) {
            return p.accepting();
        }
        throw new IllegalStateException();
    }
}
