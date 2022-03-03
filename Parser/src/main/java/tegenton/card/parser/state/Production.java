package tegenton.card.parser.state;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.InputItem;
import tegenton.card.parser.node.Node;

import java.util.ArrayList;
import java.util.List;

public class Production {
    private final Node result;
    private final List<InputItem> configuration = new ArrayList<>();
    private int index = 0;

    public Production(Node node) {
        result = node;
    }

    public boolean accept(Word word) {
        if (index < configuration.size() && configuration.get(index)
                .match(word)) {
            index++;
            return true;
        }
        return false;
    }

    public boolean accept(Node node) {
        if (index < configuration.size() && configuration.get(index)
                .match(node)) {
            index++;
            return true;
        }
        return false;
    }

    public void add(Word word) {
        configuration.add(new InputItem(word));
    }

    public void add(Node node) {
        configuration.add(new InputItem(node));
    }

    public boolean reducable() {
        return index == configuration.size();
    }

    public Node reduce() {
        return result;
    }
}
