package tegenton.card.parser.state;

import tegenton.card.parser.InputItem;
import tegenton.card.parser.node.KeywordAbilityNode;
import tegenton.card.parser.node.PermanentNode;

import java.util.List;

public class PermanentState extends State {
    @Override
    public int reducible(InputItem peek) {
        if (peek == null) {
            return 1;
        }
        return -1;
    }

    @Override
    public InputItem reduce(List<InputItem> reductionItems) {
        if (reductionItems.size() == 1) {
            return new InputItem(new PermanentNode(
                    (KeywordAbilityNode) reductionItems.get(0).getNode()));
        }
        return null;
    }

    @Override
    public State shift(InputItem pop) {
        return null;
    }
}
