package tegenton.card.parser.state;

import tegenton.card.parser.item.InputItem;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class State {
    private final Set<Production> productions = new HashSet<>();

    /**
     * Create a new state with given productions.
     *
     * @param productionList Productions of this state.
     */
    public State(final Production... productionList) {
        List<Production> propagate =
                new ArrayList<>(Arrays.asList(productionList));
        extracted(propagate);
    }

    private State() {
    }

    private void extracted(List<Production> propagate) {
        propagate.stream().map(production -> production.get(0))
                .filter(Objects::nonNull).filter(InputItem::hasNode)
                .map(InputItem::getNode)
                .forEach(node -> addAll(node.productions()));
        productions.addAll(propagate);
    }

    private void addAll(final State closure) {
        productions.addAll(closure.productions);
    }

    /**
     * Transition to the next state on a symbol.
     *
     * @param next Item to transition on.
     * @return State transitioned to.
     */
    public State shift(final InputItem next) {
        State newState = new State();
        List<Production> propagate = this.productions.stream()
                .map(production -> production.shift(next))
                .filter(Objects::nonNull).toList();
        newState.extracted(propagate);
        return newState;
    }

    /**
     * Check if the current state can be reduced.
     *
     * @param peek Upcoming input symbol.
     * @return -1 if this state cannot be reduced, or the number of tokens
     * utilized in reduction.
     */
    public int reducible(final InputItem peek) {
        return productions.stream()
                .map(production -> production.reducible(peek))
                .filter(i -> i != -1).findAny().orElse(-1);
    }

    /**
     * Reduce the current state.
     *
     * @param stack Tokens consumed to reach the current state.
     * @param peek  Upcoming input token.
     * @return Product of this state's reduction
     * @throws ParseException If this state cannot be reduced on the given
     *                        symbol.
     */
    public InputItem reduce(final Deque<InputItem> stack,
                            final InputItem peek) throws ParseException {
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
}
