package tegenton.card.parser;

import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;

import java.util.List;

public class PrepositionNode extends Node {
    PrepositionNode(final Preposition... prepositions) {
        super(prepositions);
    }

    public PrepositionNode(final List<Word> input) {
        super(input);
        if (nextToken() instanceof Preposition preposition) {
            consume(preposition);
        }
    }
}
