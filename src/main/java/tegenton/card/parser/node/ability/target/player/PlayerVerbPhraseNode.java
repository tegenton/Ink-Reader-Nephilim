package tegenton.card.parser.node.ability.target.player;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.TargetWord;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.parser.node.ParseNode;
import tegenton.card.parser.node.ability.target.object.ObjectNode;

import java.util.List;

public class PlayerVerbPhraseNode extends ParseNode {
    public PlayerVerbPhraseNode(PlayerVerb verb, ParseNode objectNode) {
        super(verb);
        addChild(objectNode);
    }

    public PlayerVerbPhraseNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof PlayerVerb) {
            setValue(pop());
            expect(Symbol.SPACE);
            if (peek() instanceof TargetWord) {
                addChild(new ZoneNode(getTokens()));
            } else {
                addChild(new ObjectNode(getTokens()));
            }
        }
    }
}
