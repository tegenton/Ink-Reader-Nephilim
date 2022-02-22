package tegenton.card.parser.node.modifier;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.type.TypeWord;
import tegenton.card.parser.Node;
import tegenton.card.parser.node.atom.AdjectiveNode;
import tegenton.card.parser.node.atom.DeterminerNode;
import tegenton.card.parser.node.atom.TypeNode;

import java.util.List;

public class PremodifierNode extends Node {
    public PremodifierNode(Node determinerNode) {
        super(determinerNode);
    }

    public PremodifierNode(List<Word> input) {
        super(input);
        if (nextToken() instanceof TypeWord) {
            addChild(new TypeNode(getTokens()));
        } else if (nextToken() instanceof Determiner) {
            addChild(new DeterminerNode(getTokens()));
        } else if (nextToken() == Keyword.ENCHANT) {
            addChild(new AdjectiveNode(getTokens()));
        } else {
            addChild(new AmountNode(getTokens()));
        }
    }
}
