package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.Node;
import tegenton.card.parser.node.PlayerPhraseNode;

import java.util.List;

public class SpellAbilityNode extends Node {
    SpellAbilityNode(Node... nodes) {
        super(nodes);
    }

    public SpellAbilityNode(List<Word> input) {
        super(input);
        addChild(new PlayerPhraseNode(getTokens()));
        addChild(new PunctuationNode(getTokens()));
    }
}
