package tegenton.card.parser.node.phrase;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;
import tegenton.card.parser.node.phrase.headword.ObjectNode;

import java.util.List;

public class PlayerVerbPhraseNode extends Node {
    public PlayerVerbPhraseNode(final PlayerVerb draw,
                                final ObjectNode objectNode) {
        super(draw);
        addChild(objectNode);
    }

    public PlayerVerbPhraseNode(final List<Word> tokens) throws ParseError {
        super(tokens);
        consume(PlayerVerb.class);
        expect(Symbol.SPACE);
        if (getTokens().get(2) == Noun.REST) {
            consume(Determiner.THE);
            expect(Symbol.SPACE);
            consume(Noun.REST);
        } else {
            addChild(new ObjectNode(getTokens()));
        }
    }
}
