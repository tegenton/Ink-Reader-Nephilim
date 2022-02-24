package tegenton.card.parser;

import tegenton.card.parser.ability.KeywordNode;

import java.util.Objects;

public class PermanentNode {
    private final KeywordNode keywordNode;

    public PermanentNode(KeywordNode keywordNode) {
        this.keywordNode = keywordNode;
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
        return Objects.equals(keywordNode, that.keywordNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keywordNode);
    }
}
