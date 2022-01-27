package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.Type;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TypesNode extends ParseNode {
    private ConjunctionNode conjunctionNode;

    public TypesNode(ParseNode... children) {
        super(Arrays.asList(children).subList(1, children.length).toArray(new ParseNode[]{}));
        conjunctionNode = (ConjunctionNode) children[0];
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
                    conjunctionNode = new ConjunctionNode(getTokens());
                    expect(Symbol.SPACE);
                    addChild(new TypeNode(getTokens()));
                }
            }
        } else {
            expect(Symbol.SPACE);
            conjunctionNode = new ConjunctionNode(getTokens());
            expect(Symbol.SPACE);
            addChild(new TypeNode(getTokens()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TypesNode typesNode = (TypesNode) o;
        return Objects.equals(conjunctionNode, typesNode.conjunctionNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), conjunctionNode);
    }
}
