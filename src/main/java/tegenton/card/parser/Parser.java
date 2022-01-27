package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.ParseNode;

import java.util.List;

public class Parser {
    public ParseNode parse(List<Word> tokens) {
        return new CardNode(tokens);
    }
}
