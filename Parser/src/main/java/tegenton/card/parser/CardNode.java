package tegenton.card.parser;

import java.util.Objects;

public class CardNode {
    private final PermanentNode permanentNode;

    public CardNode(PermanentNode permanentNode) {
        this.permanentNode = permanentNode;
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
        return Objects.equals(permanentNode, cardNode.permanentNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permanentNode);
    }
}
