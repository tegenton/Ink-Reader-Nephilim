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

    public Production(Node output, List<InputItem> list) {
        this.items = list;
        this.output = output;
    }

    public static Production of(Node output, InputItem... items) {
        return new Production(output, Arrays.asList(items));
    }

    public void setAccepting(boolean accepting) {
        this.accepting = accepting;
    }

    public InputItem get(int i) {
        return items.get(i);
    }

    public Production shift(InputItem next) {
        if (index < items.size() && items.get(index).match(next)) {
            Production newProduction = new Production(output, items);
            newProduction.index = this.index + 1;
            newProduction.accepting = this.accepting;
            newProduction.lookahead = this.lookahead;
            return newProduction;
        }
        return null;
    }

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

    public int reducible(InputItem peek) {
        if (index == items.size()) {
            if (lookahead == null || lookahead.match(peek)) {
                return index;
            }
        }
        return -1;
    }

    public InputItem reduce(Deque<InputItem> stack, InputItem peek) {
        return new InputItem(output.apply(stack, peek));
    }

    public boolean accepting() {
        return accepting;
    }

    public void setLookahead(InputItem item) {
        lookahead = item;
    }

    @Override
    public boolean equals(Object o) {
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

    @Override
    public int hashCode() {
        return Objects.hash(items, output, accepting, index);
    }
}
