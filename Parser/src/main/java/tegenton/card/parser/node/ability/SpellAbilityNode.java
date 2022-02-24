package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;
import tegenton.card.parser.node.atom.symbol.PunctuationNode;
import tegenton.card.parser.node.phrase.PhraseNode;

import java.util.List;

public class SpellAbilityNode extends Node {
    public SpellAbilityNode(Node... nodes) {
        super(nodes);
    }

    public SpellAbilityNode(List<Word> input) throws ParseError {
        super(input);
        addChild(new PhraseNode(getTokens()));
        addChild(new PunctuationNode(getTokens()));
        if (nextToken() == ObjectNoun.IT) {
            addChild(new PhraseNode(getTokens()));
            addChild(new PunctuationNode(getTokens()));
        }
    }
}
