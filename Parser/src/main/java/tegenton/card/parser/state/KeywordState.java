package tegenton.card.parser.state;

import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.InputItem;
import tegenton.card.parser.node.KeywordNode;

import java.util.List;

public class KeywordState extends State {
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
            return new InputItem(
                    new KeywordNode((Keyword) reductionItems.get(0).getWord()));
        }
        return null;
    }

    @Override
    public State shift(InputItem pop) {
        return null;
    }
}
