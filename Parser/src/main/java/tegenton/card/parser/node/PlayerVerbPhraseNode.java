package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import java.util.List;

public class PlayerVerbPhraseNode extends Node {
    public PlayerVerbPhraseNode(final PlayerVerb draw,
                                final ObjectNode objectNode) {
        super(draw);
        addChild(objectNode);
    }

    public PlayerVerbPhraseNode(final List<Word> tokens) {
        super(tokens);
        consume(PlayerVerb.DRAW);
        expect(Symbol.SPACE);
        addChild(new ObjectNode(getTokens()));
    }
}
