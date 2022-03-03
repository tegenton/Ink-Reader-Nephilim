package tegenton.card.parser.node;

import java.util.Objects;

public class PermanentNode extends Node {
    private KeywordNode node;

    public PermanentNode(KeywordNode node) {
        this.node = node;
    }

    public PermanentNode() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PermanentNode that = (PermanentNode) o;
        return Objects.equals(node, that.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}
