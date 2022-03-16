package tegenton.card.parser.state;

import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.node.Node;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class Production {
    private final List<InputItem> items;
    private final Node output;
    private boolean accepting = false;
    private int index = 0;
    private InputItem lookahead;

    Production(final Node product, final List<InputItem> symbols) {
        this.items = symbols;
        this.output = product;
    }

    /**
     * Static production initializer.
     *
     * @param product Node that this production produces.
     * @param symbols Symbols for this production to match against.
     * @return Production of the given node using the given symbols.
     */
    public static Production of(final Node product,
                                final InputItem... symbols) {
        return new Production(product, Arrays.asList(symbols));
    }

    /**
     * Set whether completing this production leads to an accepting state.
     *
     * @param isAccepting Should this production lead to an accepting state?
     */
    public void setAccepting(final boolean isAccepting) {
        this.accepting = isAccepting;
    }

    /**
     * Retrieve a specific item from this production.
     *
     * @param i Index of item to retrieve.
     * @return Item at the specified index.
     */
    public InputItem get(final int i) {
        return items.get(i);
    }

    /**
     * @param next Upcoming item from input.
     * @return New production representing the current production after parsing
     * the next symbol.
     */
    public Production shift(final InputItem next) {
        if (index < items.size() && items.get(index).match(next)) {
            Production newProduction = new Production(output, items);
            newProduction.index = this.index + 1;
            newProduction.accepting = this.accepting;
            newProduction.lookahead = this.lookahead;
            return newProduction;
        }
        return null;
    }

    /**
     * Determine if this production is complete and reducible.
     *
     * @param peek Upcoming input symbol.
     * @return Can this production be reduced?
     */
    public int reducible(final InputItem peek) {
        if (index == items.size()) {
            if (lookahead == null || lookahead.match(peek)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Reduce this production to its output.
     *
     * @param stack Previously parsed symbols.
     * @param peek  Upcoming input symbol.
     * @return Node containing information from this production.
     */
    public InputItem reduce(final Deque<InputItem> stack,
                            final InputItem peek) {
        return new InputItem(output.apply(stack, peek));
    }

    /**
     * Does this production lead to an accepting state?
     *
     * @return Is this production accepting?
     */
    public boolean accepting() {
        return accepting;
    }

    /**
     * Set a lookahead, which means that this production will not be reduced
     * unless the upcoming symbol matches the lookahead.
     *
     * @param item Item to look for before reducing.
     */
    public void setLookahead(final InputItem item) {
        lookahead = item;
    }

    /**
     * Generate a string representing this production.
     *
     * @return String form of this production.
     */
    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            if (i == index) {
                temp.append("\u2022");
            }
            temp.append(items.get(i));
        }
        if (index == items.size()) {
            temp.append("\u2022");
        }
        return temp.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Production that = (Production) o;
        return accepting == that.accepting && index == that.index
                && Objects.equals(items, that.items) && Objects.equals(output,
                that.output);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(items, output, accepting, index);
    }
}
