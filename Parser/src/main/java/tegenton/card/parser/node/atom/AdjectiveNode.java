package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;

import java.util.List;

public class AdjectiveNode extends Node {
    public AdjectiveNode(List<Word> tokens) throws ParseError {
        super(tokens);
        if (nextToken() == Keyword.ENCHANT) {
            consume(Keyword.ENCHANT);
            consume(Morpheme.ED);
        } else {
            consume(ObjectVerb.ATTACK);
            consume(Morpheme.ING);
        }
    }
}
