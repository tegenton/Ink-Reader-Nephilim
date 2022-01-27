package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.parser.node.target.object.ObjectNode;

import java.util.List;

public class PlayerVerbPhraseNode extends ParseNode {
    public PlayerVerbPhraseNode(PlayerVerb draw, ObjectNode objectNode) {
        super(draw);
        addChild(objectNode);
    }

    public PlayerVerbPhraseNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof PlayerVerb) {
            setValue(pop());
            expect(Symbol.SPACE);
            addChild(new ObjectNode(getTokens()));
        }
    }
}
