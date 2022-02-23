package tegenton.card.parser.node.atom;

import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;

import java.util.List;

public class PrepositionNode extends Node {
    PrepositionNode(final Preposition... prepositions) {
        super(prepositions);
    }

    public PrepositionNode(final List<Word> input) throws ParseError {
        super(input);
        if (nextToken() instanceof Preposition preposition) {
            consume(preposition);
        }
    }
}
