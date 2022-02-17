package tegenton.card.parser.node;

import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.List;

public class DeterminerNode extends Node {
    public DeterminerNode(final Word determiner) {
        super(determiner);
    }

    public DeterminerNode(final List<Word> tokens) {
        super(tokens);
        if (nextToken() == EnglishNumber.THREE) {
            consume(EnglishNumber.THREE);
        } else {
            consume(Determiner.TARGET);
        }
    }
}
