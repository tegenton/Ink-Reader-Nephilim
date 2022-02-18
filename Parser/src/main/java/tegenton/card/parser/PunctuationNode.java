package tegenton.card.parser;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.Node;

import java.util.List;

public class PunctuationNode extends Node {
    public PunctuationNode(Symbol period) {
        super(period);
    }

    public PunctuationNode(List<Word> tokens) {
        super(tokens);
        consume(Symbol.PERIOD);
    }
}
