package tegenton.card.parser.node;

import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.Node;

import java.util.List;

public class AmountNode extends Node {
    public AmountNode(EnglishNumber three) {
        super(three);
    }

    public AmountNode(List<Word> tokens) {
        super(tokens);
        consume(EnglishNumber.THREE);
    }
}
