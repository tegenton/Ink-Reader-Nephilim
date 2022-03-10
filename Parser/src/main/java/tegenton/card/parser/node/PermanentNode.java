package tegenton.card.parser.node;

public class PermanentNode extends Node {
    public PermanentNode(KeywordAbilityNode keywordAbilityNode) {
    }

    public PermanentNode() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PermanentNode;
    }
}
