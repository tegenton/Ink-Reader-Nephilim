package tegenton.card.parser.node.type;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.Type;
import tegenton.card.parser.node.ConjunctionNode;
import tegenton.card.parser.node.ParentNode;
import tegenton.card.parser.node.ParseNode;

import java.util.List;

public class TypesNode extends ParentNode {
    public TypesNode(ParseNode... children) {
        super(children);
    }

    public TypesNode(List<Word> tokens) {
        super(tokens);
        addChild(new TypeNode(getTokens()));
        if (getTokens().size() > 0 && peek() == Symbol.COMMA) {
            while (getTokens().size() > 0 && peek() == Symbol.COMMA) {
                pop();
                expect(Symbol.SPACE);
                if (peek() instanceof Type) {
                    addChild(new TypeNode(getTokens()));
                } else {
                    setConjunction(new ConjunctionNode(getTokens()));
                    expect(Symbol.SPACE);
                    addChild(new TypeNode(getTokens()));
                }
            }
        } else {
            expect(Symbol.SPACE);
            setConjunction(new ConjunctionNode(getTokens()));
            expect(Symbol.SPACE);
            addChild(new TypeNode(getTokens()));
        }
    }
}
