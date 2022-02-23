package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;

import java.util.List;

public class DeterminerNode extends Node {
    public DeterminerNode(final Word determiner) {
        super(determiner);
    }

    public DeterminerNode(final List<Word> tokens) throws ParseError {
        super(tokens);
        if (nextToken() == Adverb.NOT) {
            consume(Adverb.NOT);
        } else {
            consume(Determiner.class);
        }
    }
}
