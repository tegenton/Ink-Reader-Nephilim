package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.AbilityNode;

import java.util.List;

public class Parser {
    public static AbilityNode parse(final List<Word> tokens) {
        return new AbilityNode();
    }
}
