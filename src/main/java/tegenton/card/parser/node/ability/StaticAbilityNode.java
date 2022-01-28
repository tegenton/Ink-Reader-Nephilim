package tegenton.card.parser.node.ability;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.TargetAuxiliaryVerb;
import tegenton.card.parser.node.ParseNode;
import tegenton.card.parser.node.ability.target.object.ObjectAuxiliaryNode;
import tegenton.card.parser.node.ability.target.object.ObjectNode;

import java.util.List;

public class StaticAbilityNode extends ParseNode {
    public StaticAbilityNode(TargetAuxiliaryVerb continuousVerb, ParseNode... children) {
        super(children);
        setValue(continuousVerb);
    }

    public StaticAbilityNode(List<Word> tokens) {
        super(tokens);
        addChild(new ObjectNode(getTokens()));
        expect(Symbol.SPACE);
        setValue(expect(TargetAuxiliaryVerb.CAN));
        expect(Symbol.SPACE);
        addChild(new ObjectAuxiliaryNode(getTokens()));
    }
}
