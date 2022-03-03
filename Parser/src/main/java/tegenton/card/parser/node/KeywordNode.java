package tegenton.card.parser.node;

import tegenton.card.lexicon.Word;

public class KeywordNode extends Node {
    public KeywordNode(Word... words) {

    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof KeywordNode;
    }
}
