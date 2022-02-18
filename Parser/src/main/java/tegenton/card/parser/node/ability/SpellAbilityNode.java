package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.Node;
import tegenton.card.parser.node.atom.symbol.PunctuationNode;
import tegenton.card.parser.node.phrase.PlayerPhraseNode;

import java.util.List;

public class SpellAbilityNode extends Node {
    public SpellAbilityNode(Node... nodes) {
        super(nodes);
    }

    public SpellAbilityNode(List<Word> input) {
        super(input);
        addChild(new PlayerPhraseNode(getTokens()));
        addChild(new PunctuationNode(getTokens()));
    }
}
