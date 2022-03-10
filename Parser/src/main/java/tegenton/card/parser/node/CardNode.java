package tegenton.card.parser.node;

import java.util.Objects;

public class CardNode extends Node {
    private final Node node;

    public CardNode(PermanentNode permanentNode) {
        node = permanentNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CardNode cardNode = (CardNode) o;
        return Objects.equals(node, cardNode.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}
