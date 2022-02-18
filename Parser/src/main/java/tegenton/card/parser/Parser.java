package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.CardNode;

import java.util.List;

public class Parser {
    public static Node parse(final List<Word> tokens) {
        return new CardNode(tokens);
    }
}
