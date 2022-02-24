package tegenton.card.parser;

import java.util.Objects;

public class ParseTree {
    private final CardNode cardNode;

    public ParseTree(CardNode cardNode) {
        this.cardNode = cardNode;
    }

    public ParseTree() {
        this.cardNode = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParseTree parseTree = (ParseTree) o;
        return Objects.equals(cardNode, parseTree.cardNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNode);
    }
}
