package tegenton.card.parser.node;

import tegenton.card.lexicon.Word;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class ParentNode extends ParseNode {
    protected ConjunctionNode conjunctionNode;

    public ParentNode(List<Word> tokens) {
        super(tokens);
    }

    public ParentNode(ParseNode[] children) {
        super(Arrays.asList(children).subList(1, children.length).toArray(new ParseNode[]{}));
        conjunctionNode = (ConjunctionNode) children[0];
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        ParentNode parentNode = (ParentNode) o;
        return Objects.equals(conjunctionNode, parentNode.conjunctionNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), conjunctionNode);
    }

    protected void setConjunction(ConjunctionNode conjunctionNode) {
        this.conjunctionNode = conjunctionNode;
    }
}
