package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;
import tegenton.card.parser.node.ability.RestrictionNode;
import tegenton.card.parser.node.ability.SpellAbilityNode;

import java.util.List;

public class SpellNode extends Node {
    public SpellNode(SpellAbilityNode spellAbilityNode) {
        super(spellAbilityNode);
    }

    public SpellNode(List<Word> input) throws ParseError {
        super(input);
        if (nextToken() == PlayerVerb.CAST) {
            addChild(new RestrictionNode(getTokens()));
        }
        addChild(new SpellAbilityNode(getTokens()));
        if (nextToken() != null) {
            expect(Symbol.SPACE);
            addChild(new SpellAbilityNode(getTokens()));
        }
    }
}
