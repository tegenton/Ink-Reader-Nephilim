package tegenton.card.parser.node;

import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;

import java.util.List;

public class CardNode extends Node {

    public CardNode(Node... nodes) {
        super(nodes);
    }

    public CardNode(final List<Word> input) throws ParseError {
        super(input);
        if (getTokens().size() > 0) {
            if (nextToken() instanceof Keyword) {
                addChild(new PermanentNode(getTokens()));
            } else {
                addChild(new SpellNode(getTokens()));
            }
        }
    }

}
