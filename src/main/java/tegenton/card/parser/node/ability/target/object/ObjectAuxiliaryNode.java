package tegenton.card.parser.node.ability.target.object;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;
import tegenton.card.parser.node.ParseNode;
import tegenton.card.parser.node.SubordinateClauseNode;

import java.util.List;

public class ObjectAuxiliaryNode extends ParseNode {
    public ObjectAuxiliaryNode(ObjectVerb auxiliary, ParseNode... children) {
        super(children);
        setValue(auxiliary);
    }

    public ObjectAuxiliaryNode(List<Word> tokens) {
        super(tokens);
        setValue(expect(ObjectVerb.ATTACK));
        expect(Symbol.SPACE);
        addChild(new SubordinateClauseNode(getTokens()));
    }
}
