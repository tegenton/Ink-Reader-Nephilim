package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;
import tegenton.card.parser.node.ability.SpellAbilityNode;

import java.util.List;

public class SpellNode extends Node {
    public SpellNode(SpellAbilityNode spellAbilityNode) {
        super(spellAbilityNode);
    }

    public SpellNode(List<Word> input) throws ParseError {
        super(input);
        addChild(new SpellAbilityNode(getTokens()));
        if (nextToken() != null) {
            expect(Symbol.SPACE);
            addChild(new SpellAbilityNode(getTokens()));
        }
    }
}
