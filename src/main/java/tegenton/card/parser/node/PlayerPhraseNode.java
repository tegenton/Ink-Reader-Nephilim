package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.target.player.PlayerNode;

import java.util.List;

public class PlayerPhraseNode extends ParseNode {
    public PlayerPhraseNode(ParseNode... children) {
        super(children);
    }

    public PlayerPhraseNode(List<Word> tokens) {
        super(tokens);
        addChild(new PlayerNode(getTokens()));
        expect(Symbol.SPACE);
        addChild(new PlayerVerbPhraseNode(getTokens()));
    }
}
