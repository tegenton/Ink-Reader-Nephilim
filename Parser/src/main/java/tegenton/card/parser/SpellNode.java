package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.Node;

import java.util.List;

public class SpellNode extends Node {
    public SpellNode(SpellAbilityNode spellAbilityNode) {
        super(spellAbilityNode);
    }

    public SpellNode(List<Word> input) {
        super(input);
        addChild(new SpellAbilityNode(getTokens()));
    }
}
