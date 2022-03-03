package tegenton.card.parser.node;

import tegenton.card.lexicon.game.Keyword;

public class KeywordNode {
    public KeywordNode(Keyword banding) {
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof KeywordNode;
    }
}
