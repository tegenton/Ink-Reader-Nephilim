package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.Node;

import java.util.List;

public class AdjectiveNode extends Node {
    public AdjectiveNode(List<Word> tokens) {
        super(tokens);
        consume(Keyword.ENCHANT);
        consume(Morpheme.ED);
    }
}
