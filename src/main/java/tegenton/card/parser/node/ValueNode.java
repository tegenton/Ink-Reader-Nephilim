package tegenton.card.parser.node;

import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.lexicon.value.ValueWord;

import java.util.List;

public class ValueNode extends ParseNode {
    public ValueNode(EnglishNumber three) {
        super(three);
    }

    public ValueNode(List<Word> tokens) {
        super(tokens);
        if (peek() instanceof ValueWord) {
            setValue(pop());
        }
    }
}
