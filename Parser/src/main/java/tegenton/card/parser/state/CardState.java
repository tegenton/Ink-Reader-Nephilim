package tegenton.card.parser.state;

import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.InputItem;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.KeywordAbilityNode;
import tegenton.card.parser.node.KeywordNode;
import tegenton.card.parser.node.PermanentNode;

import java.util.List;

public class CardState extends State {
    @Override
    public int reducible(InputItem peek) {
        if (peek == null) {
            return 1;
        }
        return -1;
    }

    @Override
    public InputItem reduce(List<InputItem> reductionItems) {
        if (reductionItems.get(0)
                .getNode() instanceof PermanentNode permanentNode) {
            return new InputItem(new CardNode(permanentNode));
        }
        return new InputItem(new CardNode(new PermanentNode()));
    }

    @Override
    public State shift(InputItem pop) {
        if (pop.getWord() instanceof Keyword) {
            return new BasicKeywordState();
        } else if (pop.hasNode()) {
            if (pop.getNode() instanceof KeywordNode) {
                return new KeywordAbilityState();
            } else if (pop.getNode() instanceof KeywordAbilityNode) {
                return new PermanentState();
            }
        }
        return null;
    }
}
