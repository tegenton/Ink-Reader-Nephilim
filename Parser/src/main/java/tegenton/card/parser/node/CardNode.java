package tegenton.card.parser.node;

import tegenton.card.lexicon.Word;

import java.util.List;

public class CardNode extends Node {
    public CardNode(final List<Word> input) {
        super(input);
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof CardNode;
    }
}
